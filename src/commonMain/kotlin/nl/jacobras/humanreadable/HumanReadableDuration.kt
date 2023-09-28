package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Day
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Hour
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Minute
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Month
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Second
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Week
import nl.jacobras.humanreadable.i18n.HumanTimeUnit.Year
import kotlin.math.roundToInt
import kotlin.time.Duration

/**
 * Returns the given [duration] in human-readable format.
 */
internal fun formatDuration(locale: HumanLocale, duration: Duration): String {
    val secondsAgo = duration.inWholeSeconds
    val hoursAgo = duration.inWholeHours
    val daysAgo = duration.inWholeDays
    val weeksAgo = (duration.inWholeDays / 7f).roundToInt()
    val monthsAgo = (duration.inWholeDays / 30.5f).roundToInt()
    val yearsAgo = duration.inWholeDays / 365

    return when {
        secondsAgo == 1L -> {
            "1 ${locale.format(Second, 1)}"
        }
        secondsAgo < 60 -> {
            "$secondsAgo ${locale.format(Second, 60)}"
        }
        secondsAgo == 60L -> {
            "1 ${locale.format(Minute, 1)}"
        }
        secondsAgo < 3600 -> {
            val minutes = duration.inWholeMinutes
            "$minutes ${locale.format(Minute, minutes)}"
        }
        hoursAgo == 1L -> {
            "1 ${locale.format(Hour, 1)}"
        }
        daysAgo < 1 -> {
            "$hoursAgo ${locale.format(Hour, hoursAgo)}"
        }
        daysAgo == 1L -> {
            "1 ${locale.format(Day, 1)}"
        }
        daysAgo < 7 -> {
            "$daysAgo ${locale.format(Day, daysAgo)}"
        }
        weeksAgo == 1 -> {
            "1 ${locale.format(Week, 1)}"
        }
        daysAgo < 30 -> {
            "$weeksAgo ${locale.format(Week, weeksAgo.toLong())}"
        }
        monthsAgo == 1 -> {
            "1 ${locale.format(Month, 1)}"
        }
        monthsAgo < 12 -> {
            "$monthsAgo ${locale.format(Month, monthsAgo.toLong())}"
        }
        yearsAgo == 1L -> {
            "1 ${locale.format(Year, 1)}"
        }
        else -> {
            "$yearsAgo ${locale.format(Year, yearsAgo)}"
        }
    }
}