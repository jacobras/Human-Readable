package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.HumanReadable.localisation
import nl.jacobras.humanreadable.HumanReadable.strings
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.TenseForms

internal enum class TimeUnit(
    val forms: (DateTimeStrings) -> TenseForms
) {
    Seconds({ it.seconds }),
    Minutes({ it.minutes }),
    Hours({ it.hours }),
    Days({ it.days }),
    Weeks({ it.weeks }),
    Months({ it.months }),
    Years({ it.years });

    fun format(value: Int, relativeTime: RelativeTime): String {
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
}