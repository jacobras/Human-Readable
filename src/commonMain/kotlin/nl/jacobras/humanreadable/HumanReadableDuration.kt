package nl.jacobras.humanreadable

import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 */
internal fun formatDuration(duration: Duration): String {
    val secondsAgo = duration.inWholeSeconds
    val hoursAgo = duration.inWholeHours
    val daysAgo = duration.inWholeDays
    val weeksAgo = (duration.inWholeDays / 7f).roundToInt()
    val monthsAgo = (duration.inWholeDays / 30.5f).roundToInt()
    val yearsAgo = duration.inWholeDays / 365

    return when {
        secondsAgo == 1L -> {
            "1 second"
        }
        secondsAgo < 60 -> {
            "$secondsAgo seconds"
        }
        secondsAgo == 60L -> {
            "1 minute"
        }
        secondsAgo < 3600 -> {
            "${duration.inWholeMinutes} minutes"
        }
        hoursAgo == 1L -> {
            "1 hour"
        }
        daysAgo < 1 -> {
            "${duration.inWholeHours} hours"
        }
        daysAgo == 1L -> {
            "1 day"
        }
        daysAgo < 7 -> {
            "$daysAgo days"
        }
        weeksAgo == 1 -> {
            "1 week"
        }
        daysAgo < 30 -> {
            "$weeksAgo weeks"
        }
        monthsAgo == 1 -> {
            "1 month"
        }
        monthsAgo < 12 -> {
            "$monthsAgo months"
        }
        yearsAgo == 1L -> {
            "1 year"
        }
        else -> {
            "$yearsAgo years"
        }
    }
}