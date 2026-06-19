package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.strings.lyricist
import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 */
internal fun formatDuration(
    duration: Duration,
    relativeTime: RelativeTime
): String {
    val secondsAgo = duration.inWholeSeconds.toInt()
    val hoursAgo = duration.inWholeHours.toInt()
    val daysAgo = duration.inWholeDays.toInt()
    val weeksAgo = (duration.inWholeDays / 7f).roundToInt()
    val monthsAgo = (duration.inWholeDays / 30.5f).roundToInt()
    val yearsAgo = (duration.inWholeDays / 365).toInt()

    return when {
        secondsAgo < 60 -> {
            formatUnit(secondsAgo, TimeUnit.Seconds, relativeTime)
        }
        secondsAgo < 3600 -> {
            val minutes = duration.inWholeMinutes.toInt()
            formatUnit(minutes, TimeUnit.Minutes, relativeTime)
        }
        daysAgo < 1 -> {
            formatUnit(hoursAgo, TimeUnit.Hours, relativeTime)
        }
        daysAgo < 7 -> {
            formatUnit(daysAgo, TimeUnit.Days, relativeTime)
        }
        daysAgo < 30 -> {
            formatUnit(weeksAgo, TimeUnit.Weeks, relativeTime)
        }
        monthsAgo < 12 || yearsAgo == 0 -> {
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
    count: Int,
    unit: TimeUnit,
    relativeTime: RelativeTime
): String {
    val unitText = unit.format(count, relativeTime)
    return if (lyricist.languageTag == "ar" && (count == 1 || count == 2)) {
        unitText
    } else {
        "$count $unitText"
    }
}