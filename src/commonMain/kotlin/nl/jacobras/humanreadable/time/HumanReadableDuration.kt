package nl.jacobras.humanreadable.time

import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.formatNumber
import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 */
internal fun formatDuration(
    duration: Duration,
    relativeTime: RelativeTime,
    rounding: Rounding,
    units: Set<TimeUnit>
): String {
    val secondsAgo = duration.inWholeSeconds.toInt()
    val minutesAgo = duration.inWholeMinutes.toInt()
    val hoursAgo = duration.inWholeHours.toInt()
    val daysAgo = duration.inWholeDays.toInt()
    val weeksAgo = (duration.inWholeDays / 7f).round(rounding)
    val monthsAgo = (duration.inWholeDays / 30.5f).round(rounding)
    val yearsAgo = (duration.inWholeDays / 365f).round(rounding)

    return when {
        units.contains(TimeUnit.Years) && yearsAgo > 0 -> {
            formatUnit(yearsAgo, TimeUnit.Years, relativeTime)
        }
        units.contains(TimeUnit.Months) && monthsAgo > 0 -> {
            formatUnit(monthsAgo, TimeUnit.Months, relativeTime)
        }
        units.contains(TimeUnit.Weeks) && weeksAgo > 0 -> {
            formatUnit(weeksAgo, TimeUnit.Weeks, relativeTime)
        }
        units.contains(TimeUnit.Days) && daysAgo > 0 -> {
            formatUnit(daysAgo, TimeUnit.Days, relativeTime)
        }
        units.contains(TimeUnit.Hours) && hoursAgo > 0 -> {
            if (rounding == Rounding.UpIfClose && hoursAgo >= 23) {
                formatUnit(1, TimeUnit.Days, relativeTime)
            } else {
                formatUnit(hoursAgo, TimeUnit.Hours, relativeTime)
            }
        }
        units.contains(TimeUnit.Minutes) && minutesAgo > 0 -> {
            if (rounding == Rounding.UpIfClose && minutesAgo >= 55) {
                formatUnit(1, TimeUnit.Hours, relativeTime)
            } else {
                formatUnit(minutesAgo, TimeUnit.Minutes, relativeTime)
            }
        }
        else -> {
            if (rounding == Rounding.UpIfClose && secondsAgo >= 55) {
                formatUnit(1, TimeUnit.Minutes, relativeTime)
            } else {
                formatUnit(secondsAgo, TimeUnit.Seconds, relativeTime)
            }
        }
    }
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
    relativeTime: RelativeTime
): String {
    val unitText = unit.format(count, relativeTime)
    val languageTag = HumanReadable.localisation.languageTag
    return when (languageTag) {
        "ar" if (count == 1 || count == 2) -> unitText
        "ko" -> "$count$unitText"
        else -> "$count $unitText"
    }
}

private fun Float.round(rounding: Rounding): Int {
    return when (rounding) {
        Rounding.Floor -> toInt()
        Rounding.HalfUp, Rounding.UpIfClose -> roundToInt()
    }
}