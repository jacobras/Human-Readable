package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.i18n.TenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.strings

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
        val dateTime = strings.dateTime
        return dateTime.word(forms(dateTime), value, relativeTime)
    }
}
