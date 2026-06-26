package nl.jacobras.humanreadable.time

import nl.jacobras.humanreadable.HumanReadable.localisation
import nl.jacobras.humanreadable.HumanReadable.strings
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.TenseForms
import nl.jacobras.humanreadable.time.Rounding.UpIfClose

public enum class TimeUnit(
    internal val forms: (DateTimeStrings) -> TenseForms
) {
    Seconds({ it.seconds }),
    Minutes({ it.minutes }),
    Hours({ it.hours }),
    Days({ it.days }),
    Weeks({ it.weeks }),
    Months({ it.months }),
    Years({ it.years });

    /**
     * When to roll over to the next larger unit for [UpIfClose] rounding.
     */
    internal val upIfCloseRollover: Int
        get() = when (this) {
            Seconds, Minutes -> 55
            Hours -> 23
            else -> Int.MAX_VALUE
        }

    internal fun format(value: Int, relativeTime: RelativeTime): String {
        val dateTimeStrings = strings.dateTime
        val tenseForms = forms(dateTimeStrings)
        val pluralCategory = dateTimeStrings.plural(value)
        val correctTense = when (relativeTime) {
            RelativeTime.Past -> tenseForms.past
            RelativeTime.Future -> tenseForms.future
            RelativeTime.Present -> tenseForms.present
        }
        return correctTense[pluralCategory]
            ?: tenseForms.present[pluralCategory]
            ?: error("No translation for $value $this in '${localisation.languageTag}'")
    }

    internal companion object {
        internal val all = entries.toSet()
    }
}