package nl.jacobras.humanreadable

import Res
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
        secondsAgo < 60 -> {
            "$secondsAgo ${Res.string.seconds.format(secondsAgo.toInt())}"
        }
        secondsAgo < 3600 -> {
            val minutes = duration.inWholeMinutes.toInt()
            "$minutes ${Res.string.minutes.format(minutes)}"
        }
        daysAgo < 1 -> {
            "$hoursAgo ${Res.string.hours.format(hoursAgo.toInt())}"
        }
        daysAgo < 7 -> {
            "$daysAgo ${Res.string.days.format(daysAgo.toInt())}"
        }
        daysAgo < 30 -> {
            "$weeksAgo ${Res.string.weeks.format(weeksAgo)}"
        }
        monthsAgo < 12 || yearsAgo == 0L -> {
            "$monthsAgo ${Res.string.months.format(monthsAgo)}"
        }
        else -> {
            "$yearsAgo ${Res.string.years.format(yearsAgo.toInt())}"
        }
    }
}