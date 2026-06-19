package nl.jacobras.humanreadable

import io.github.skeptick.libres.LibresSettings
import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 */
internal fun formatDuration(
    duration: Duration,
    relativeTime: RelativeTime
): String {
    val secondsAgo = duration.inWholeSeconds
    val hoursAgo = duration.inWholeHours
    val daysAgo = duration.inWholeDays
    val weeksAgo = (duration.inWholeDays / 7f).roundToInt().toLong()
    val monthsAgo = (duration.inWholeDays / 30.5f).roundToInt().toLong()
    val yearsAgo = duration.inWholeDays / 365

    return when {
        secondsAgo < 60L -> {
            formatUnit(secondsAgo, TimeUnit.Seconds, relativeTime)
        }
        secondsAgo < 3600L -> {
            val minutes = duration.inWholeMinutes
            formatUnit(minutes, TimeUnit.Minutes, relativeTime)
        }
        daysAgo < 1L -> {
            formatUnit(hoursAgo, TimeUnit.Hours, relativeTime)
        }
        daysAgo < 7L -> {
            formatUnit(daysAgo, TimeUnit.Days, relativeTime)
        }
        daysAgo < 30L -> {
            formatUnit(weeksAgo, TimeUnit.Weeks, relativeTime)
        }
        monthsAgo < 12L || yearsAgo == 0L -> {
            formatUnit(monthsAgo, TimeUnit.Months, relativeTime)
        }
        else -> {
            formatUnit(yearsAgo, TimeUnit.Years, relativeTime)
        }
    }
}

/**
 * Formats a [count] with its [unit]. Normally produces "$count $unit", but for Arabic the
 * singular (1) and dual (2) forms are encoded in the unit word itself, so the numeral is omitted.
 */
private fun formatUnit(
    count: Long,
    unit: TimeUnit,
    relativeTime: RelativeTime
): String {
    val unitText = unit.format(count, relativeTime)
    return if (LibresSettings.languageCode == "ar" && (count == 1L || count == 2L)) {
        unitText
    } else {
        "$count $unitText"
    }
}

/**
 * Returns the given [duration] expressed in the specified [unit], in human-readable format.
 */
internal fun formatDuration(
    duration: Duration,
    relativeTime: RelativeTime,
    unit: DurationUnit
): String {
    val (value, timeUnit) = duration.toFixedDurationUnit(unit)

    return formatUnit(value, timeUnit, relativeTime)
}

private fun Duration.toFixedDurationUnit(unit: DurationUnit): FixedDurationUnit {
    val units = listOf(
        DurationUnit.Years,
        DurationUnit.Months,
        DurationUnit.Weeks,
        DurationUnit.Days,
        DurationUnit.Hours,
        DurationUnit.Minutes,
        DurationUnit.Seconds
    )
    val requestedIndex = units.indexOf(unit)
    val requested = toFixedDurationUnitFor(unit)

    if (requested.value != 0L || unit == DurationUnit.Seconds || this == Duration.ZERO) {
        return requested
    }

    return units
        .drop(requestedIndex + 1)
        .firstNotNullOfOrNull { smallerUnit ->
            toFixedDurationUnitFor(smallerUnit).takeIf { it.value != 0L }
        }
        ?: requested
}

private fun Duration.toFixedDurationUnitFor(unit: DurationUnit): FixedDurationUnit {
    return when (unit) {
        DurationUnit.Seconds -> FixedDurationUnit(inWholeSeconds, TimeUnit.Seconds)
        DurationUnit.Minutes -> FixedDurationUnit(inWholeMinutes, TimeUnit.Minutes)
        DurationUnit.Hours -> FixedDurationUnit(inWholeHours, TimeUnit.Hours)
        DurationUnit.Days -> FixedDurationUnit(inWholeDays, TimeUnit.Days)
        DurationUnit.Weeks -> FixedDurationUnit(inWholeDays / 7, TimeUnit.Weeks)
        DurationUnit.Months -> FixedDurationUnit(inWholeDays / 30, TimeUnit.Months)
        DurationUnit.Years -> FixedDurationUnit(inWholeDays / 365, TimeUnit.Years)
    }
}

private data class FixedDurationUnit(
    val value: Long,
    val timeUnit: TimeUnit
)
