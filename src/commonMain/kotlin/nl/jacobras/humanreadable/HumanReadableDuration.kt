package nl.jacobras.humanreadable

import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 */
internal fun formatDuration(duration: Duration): String {
    val secondsAgo = duration.inWholeSeconds
    val daysAgo = duration.inWholeDays
    val weeksAgo = duration.inWholeDays / 7f
    val monthsAgo = duration.inWholeDays / 30.5f
    val yearsAgo = duration.inWholeDays / 365

    return when {
        secondsAgo < 60 -> {
            "$secondsAgo seconds"
        }
        secondsAgo < 3600 -> {
            "${duration.inWholeMinutes} minutes"
        }
        daysAgo < 1 -> {
            "${duration.inWholeHours} hours"
        }
        daysAgo < 7 -> {
            "$daysAgo days"
        }
        daysAgo < 30 -> {
            "${weeksAgo.roundToInt()} weeks"
        }
        monthsAgo < 12 -> {
            "${monthsAgo.roundToInt()} months"
        }
        else -> {
            "$yearsAgo years"
        }
    }
}