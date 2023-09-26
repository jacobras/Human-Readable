package nl.jacobras.humanreadable

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.time.Duration

object HumanReadable {

    /**
     * Returns the difference between now and [instant], in human-readable format. Also supports
     * instants in the future. For example: an instant that's 5 hours ago will return "5 hours ago".
     *
     * @param instant The [Instant] to format.
     * @return a formatted string
     */
    fun timeAgo(instant: Instant): String {
        val now = Clock.System.now()
        val diff = now - instant
        val secondsAgo = diff.inWholeSeconds

        return when {
            secondsAgo < 0 -> {
                "in ${duration(diff.absoluteValue)}"
            }
            secondsAgo <= 1 -> {
                "now"
            }
            else -> "${duration(diff)} ago"
        }
    }

    /**
     * Returns the given [duration] in human-readable format.
     * For example: a duration of 3 seconds returns "3 seconds".
     *
     * @param duration The [Duration] to format.
     * @return a formatted string
     */
    fun duration(duration: Duration): String {
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

    /**
     * Returns the given [bytes] size in human-readable format. For example:
     * a size of 3_500_000 bytes returns "3.5 MB". Assumes base 1024.
     *
     * @param bytes The size in bytes to format.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    fun fileSize(bytes: Long, decimals: Int = 1): String {
        return when {
            bytes < 1024 -> {
                "$bytes B"
            }
            bytes < 1_048_576 -> {
                "${(bytes / 1_024f).formatWithDecimals(decimals)} kB"
            }
            bytes < 1_073_741_824 -> {
                "${(bytes / 1_048_576f).formatWithDecimals(decimals)} MB"
            }
            else -> {
                "${(bytes / 1.09951163E12f).formatWithDecimals(decimals)} GB"
            }
        }
    }
}

private fun Float.formatWithDecimals(decimals: Int): String {
    val multiplier = 10.0.pow(decimals)
    val numberAsString = (this * multiplier).roundToLong().toString()
    val decimalIndex = numberAsString.length - decimals - 1
    val mainRes = numberAsString.substring(0..decimalIndex)
    val fractionRes = numberAsString.substring(decimalIndex + 1)
    return if (fractionRes.isEmpty()) {
        mainRes
    } else {
        "$mainRes.$fractionRes"
    }
}