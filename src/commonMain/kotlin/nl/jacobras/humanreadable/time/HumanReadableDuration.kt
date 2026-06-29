package nl.jacobras.humanreadable.time

import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.HumanReadable.strings
import nl.jacobras.humanreadable.formatNumber
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 *
 * @param duration The duration to format.
 * @param relativeTime Whether this is in the past, current or future (for grammatical correctness).
 * @param formatStyle The [FormatStyle] to use.
 * @param parts Configures the formatting of multiple parts (defaults to 1 part).
 * @param units The [TimeUnit]s to limit to during formatting.
 * @param rounding The [Rounding] strategy to use.
 */
internal fun formatDuration(
    duration: Duration,
    relativeTime: RelativeTime,
    formatStyle: FormatStyle,
    parts: Parts,
    units: Set<TimeUnit>,
    rounding: Rounding
): String {
    val tooSmall = parts.smallestDuration > Duration.ZERO && duration < parts.smallestDuration

    val parts = getNeededParts(
        units = units,
        duration = if (tooSmall) parts.smallestDuration else duration,
        rounding = rounding,
        parts = parts
    )

    return buildString {
        if (tooSmall) {
            // Too small? Add "less than ..."
            when (formatStyle.dateTimeUnits) {
                FormatStyle.DateTimeUnits.Long -> {
                    append(strings.dateTime.lessThan)
                    append(' ')
                }
                FormatStyle.DateTimeUnits.Short -> append('<')
                FormatStyle.DateTimeUnits.Narrow -> append('<')
            }
        } else if (formatStyle.approximation && duration != parts.totalDuration) {
            // Large enough, somewhere rounding occurred? Add "about ..."
            append(strings.dateTime.about)
            append(' ')
        }

        // Format all parts
        for ((unit, value) in parts) {
            if (unit != parts.keys.first()) {
                when (formatStyle.dateTimeUnits) {
                    FormatStyle.DateTimeUnits.Long -> append(", ")
                    FormatStyle.DateTimeUnits.Short -> append(", ")
                    FormatStyle.DateTimeUnits.Narrow -> append(" ")
                }
            }
            append(formatUnit(value, unit, relativeTime, formatStyle.dateTimeUnits))
        }

        // Nothing to format? Add "0 ..."
        if (isEmpty() && units.isNotEmpty()) {
            append(formatUnit(0, units.first(), relativeTime, formatStyle.dateTimeUnits))
        }
    }
}

private fun getNeededParts(
    units: Set<TimeUnit>,
    duration: Duration,
    rounding: Rounding,
    parts: Parts
): Map<TimeUnit, Int> {
    val unitsDescending = units.sorted().reversed()
    val res = mutableMapOf<TimeUnit, Int>()
    var remainingDuration = duration

    // Initial parts division
    for (unit in unitsDescending) {
        if (res.size == parts.max) {
            break
        }

        val value = unit.calculateValue(remainingDuration, rounding)
        if (value > 0) {
            res[unit] = value
            remainingDuration -= unit.valueToDuration(value)
        }
    }

    // Roll-overs
    if (rounding == Rounding.UpIfClose) {
        val unitsAscending = res.keys.sorted()

        for (unit in unitsAscending) {
            val value = res[unit] ?: continue
            if (value >= unit.upIfCloseRollover) {
                val largerUnit = TimeUnit.entries.getOrNull(unit.ordinal + 1)
                if (largerUnit != null) {
                    res[largerUnit] = (res[largerUnit] ?: 0) + 1
                    res.remove(unit)
                }
            }
        }
    }

    // Sub-part cut-offs
    if (parts.subpartCutOffs.isNotEmpty()) {
        for ((cutoffUnit, cutoffValue) in parts.subpartCutOffs) {
            val value = res[cutoffUnit]
            if (value != null && value >= cutoffValue) {
                res.keys.removeAll { it < cutoffUnit }
            }
        }
    }
    return res
}

private val Map<TimeUnit, Int>.totalDuration: Duration
    get() = entries.maxOf { (unit, value) ->
        unit.valueToDuration(value)
    }

/**
 * Formats a [count] with its [unit].
 *
 * Note about Arabic: normally this produces "$count $unit", but for Arabic the
 * singular (1) and dual (2) forms are encoded in the unit word itself, so the
 * numeral is omitted.
 *
 * Note about Korean: the number and unit are written without a separating space, e.g. "2초".
 */
private fun formatUnit(
    count: Int,
    unit: TimeUnit,
    relativeTime: RelativeTime,
    formatStyle: FormatStyle.DateTimeUnits
): String {
    val formattedCount = if (count > 1_000) {
        count.toDouble().formatNumber(decimals = 0)
    } else {
        count.toString()
    }

    val unitText = unit.format(count, relativeTime, formatStyle)
    val languageTag = HumanReadable.localisation.languageTag
    return when (languageTag) {
        "ar" if (count == 1 || count == 2) -> unitText
        "ko" -> "$formattedCount$unitText"
        else -> {
            if (formatStyle == FormatStyle.DateTimeUnits.Narrow) {
                "$formattedCount$unitText"
            } else {
                "$formattedCount $unitText"
            }
        }
    }
}