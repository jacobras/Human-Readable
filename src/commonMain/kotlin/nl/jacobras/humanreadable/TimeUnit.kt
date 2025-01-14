package nl.jacobras.humanreadable

import Res
import io.github.skeptick.libres.strings.VoidPluralString

internal enum class TimeUnit(
    val past: () -> VoidPluralString,
    val present: () -> VoidPluralString,
    val future: () -> VoidPluralString
) {
    Seconds(
        past = { Res.string.seconds_past },
        present = { Res.string.seconds },
        future = { Res.string.seconds_future }
    ),
    Minutes(
        past = { Res.string.minutes_past },
        present = { Res.string.minutes },
        future = { Res.string.minutes_future }
    ),
    Hours(
        past = { Res.string.hours_past },
        present = { Res.string.hours },
        future = { Res.string.hours_future }
    ),
    Days(
        past = { Res.string.days_past },
        present = { Res.string.days },
        future = { Res.string.days_future }
    ),
    Weeks(
        past = { Res.string.weeks_past },
        present = { Res.string.weeks },
        future = { Res.string.weeks_future }
    ),
    Months(
        past = { Res.string.months_past },
        present = { Res.string.months },
        future = { Res.string.months_future }
    ),
    Years(
        past = { Res.string.years_past },
        present = { Res.string.years },
        future = { Res.string.years_future }
    );

    fun format(value: Int, relativeTime: RelativeTime): String {
        return when (relativeTime) {
            RelativeTime.Past -> past().optionallyFormat(value) ?: present().format(value)
            RelativeTime.Present -> present().format(value)
            RelativeTime.Future -> future().optionallyFormat(value) ?: present().format(value)
        }
    }
}