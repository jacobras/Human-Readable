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
    val secondsAgo = duration.inWholeSeconds.toInt()
    val hoursAgo = duration.inWholeHours.toInt()
    val daysAgo = duration.inWholeDays.toInt()
    val weeksAgo = (duration.inWholeDays / 7f).roundToInt()
    val monthsAgo = (duration.inWholeDays / 30.5f).roundToInt()
    val yearsAgo = (duration.inWholeDays / 365).toInt()

    val result = when {
        secondsAgo < 60 -> {
            "$secondsAgo ${TimeUnit.Seconds.format(secondsAgo, relativeTime)}"
        }
        secondsAgo < 3600 -> {
            val minutes = duration.inWholeMinutes.toInt()
            "$minutes ${TimeUnit.Minutes.format(minutes, relativeTime)}"
        }
        daysAgo < 1 -> {
            "$hoursAgo ${TimeUnit.Hours.format(hoursAgo, relativeTime)}"
        }
        daysAgo < 7 -> {
            "$daysAgo ${TimeUnit.Days.format(daysAgo, relativeTime)}"
        }
        daysAgo < 30 -> {
            "$weeksAgo ${TimeUnit.Weeks.format(weeksAgo, relativeTime)}"
        }
        monthsAgo < 12 || yearsAgo == 0 -> {
            "$monthsAgo ${TimeUnit.Months.format(monthsAgo, relativeTime)}"
        }
        else -> {
            "$yearsAgo ${TimeUnit.Years.format(yearsAgo, relativeTime)}"
        }
    }

    return if (LibresSettings.languageCode == "ar" && (result.startsWith("1 ") || result.startsWith("2 "))) {
        result.substringAfter(" ")
    } else {
        result
    }
}