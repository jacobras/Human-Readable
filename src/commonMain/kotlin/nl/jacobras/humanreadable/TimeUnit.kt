package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.TenseForms
import nl.jacobras.humanreadable.strings.strings

internal enum class TimeUnit(
    val forms: (HumanReadableStrings) -> TenseForms
) {
    Seconds({ it.seconds }),
    Minutes({ it.minutes }),
    Hours({ it.hours }),
    Days({ it.days }),
    Weeks({ it.weeks }),
    Months({ it.months }),
    Years({ it.years });

    fun format(value: Int, relativeTime: RelativeTime): String {
        val current = strings
        return current.word(forms(current), value, relativeTime)
    }
}
