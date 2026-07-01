package nl.jacobras.humanreadable.time

import nl.jacobras.humanreadable.HumanReadable.localisation
import nl.jacobras.humanreadable.HumanReadable.strings
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.TenseForms
import nl.jacobras.humanreadable.time.Rounding.UpIfClose
import kotlin.math.roundToInt
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

// TODO: extensions instead of parameters? Cleaner public API
public enum class TimeUnit(
    internal val calculateValue: (Duration, Rounding) -> Int,
    internal val valueToDuration: (Int) -> Duration,
    internal val longForms: (DateTimeStrings) -> TenseForms,
    internal val shortForms: (DateTimeStrings) -> TenseForms,
    internal val narrowForms: (DateTimeStrings) -> TenseForms,
) {
    Seconds(
        calculateValue = { duration, rounding -> duration.inWholeSeconds.toFloat().round(rounding) },
        valueToDuration = { it.seconds },
        longForms = { it.secondsLong },
        shortForms = { it.secondsShort },
        narrowForms = { it.secondsNarrow }
    ),
    Minutes(
        calculateValue = { duration, rounding -> (duration.inWholeSeconds / 60f).round(rounding) },
        valueToDuration = { it.minutes },
        longForms = { it.minutesLong },
        shortForms = { it.minutesShort },
        narrowForms = { it.minutesNarrow }
    ),
    Hours(
        calculateValue = { duration, rounding -> (duration.inWholeMinutes / 60f).round(rounding) },
        valueToDuration = { it.hours },
        longForms = { it.hoursLong },
        shortForms = { it.hoursShort },
        narrowForms = { it.hoursNarrow }
    ),
    Days(
        calculateValue = { duration, rounding -> duration.inWholeDays.toFloat().round(rounding) },
        valueToDuration = { it.days },
        longForms = { it.daysLong },
        shortForms = { it.daysShort },
        narrowForms = { it.daysNarrow }
    ),
    Weeks(
        calculateValue = { duration, rounding -> (duration.inWholeDays / 7f).round(rounding) },
        valueToDuration = { (it * 7).days },
        longForms = { it.weeksLong },
        shortForms = { it.weeksShort },
        narrowForms = { it.weeksNarrow }
    ),
    Months(
        calculateValue = { duration, rounding -> (duration.inWholeDays / 30.5f).round(rounding) },
        valueToDuration = { (it * 30.5).days },
        longForms = { it.monthsLong },
        shortForms = { it.monthsShort },
        narrowForms = { it.monthsNarrow }
    ),
    Years(
        calculateValue = { duration, rounding -> (duration.inWholeDays / 365f).round(rounding) },
        valueToDuration = { (it * 365).days },
        longForms = { it.yearsLong },
        shortForms = { it.yearsShort },
        narrowForms = { it.yearsNarrow }
    );

    /**
     * When to roll over to the next larger unit for [UpIfClose] rounding.
     */
    internal val upIfCloseRollover: Int
        get() = when (this) {
            Seconds, Minutes -> 55
            Hours -> 23
            else -> Int.MAX_VALUE
        }

    internal fun format(value: Int, relativeTime: RelativeTime, formatStyle: FormatStyle.DateTimeUnits): String {
        val dateTimeStrings = strings.dateTime
        val tenseForms = when (formatStyle) {
            FormatStyle.DateTimeUnits.Long -> longForms(dateTimeStrings)
            FormatStyle.DateTimeUnits.Short -> shortForms(dateTimeStrings)
            FormatStyle.DateTimeUnits.Narrow -> narrowForms(dateTimeStrings)
        }
        val pluralCategory = dateTimeStrings.plural(value)
        val correctTense = when (relativeTime) {
            RelativeTime.Past -> tenseForms.past
            RelativeTime.Future -> tenseForms.future
            RelativeTime.Present -> tenseForms.present
        }
        return correctTense[pluralCategory]
            ?: tenseForms.present[pluralCategory]
            ?: tenseForms.present.values.firstOrNull()
            ?: error("No translation for $value $this in '${localisation.languageTag}'")
    }

    internal companion object {
        internal val all = entries.toSet()
    }
}

private fun Float.round(rounding: Rounding): Int {
    return when (rounding) {
        Rounding.Floor, UpIfClose -> toInt()
        Rounding.HalfUp -> roundToInt()
    }
}