package nl.jacobras.humanreadable

import io.github.skeptick.libres.LibresSettings
import io.github.skeptick.libres.strings.VoidPluralString
import HumanReadableRes as Res

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

    fun format(value: Long, relativeTime: RelativeTime): String {
        val pluralSample = value.pluralSample()
        return when (relativeTime) {
            RelativeTime.Past -> past().optionallyFormat(pluralSample) ?: present().format(pluralSample)
            RelativeTime.Present -> present().format(pluralSample)
            RelativeTime.Future -> future().optionallyFormat(pluralSample) ?: present().format(pluralSample)
        }
    }
}

private fun Long.pluralSample(): Int {
    val positiveValue = when {
        this == Long.MIN_VALUE -> Long.MAX_VALUE
        this < 0L -> -this
        else -> this
    }

    if (positiveValue > Int.MAX_VALUE && LibresSettings.languageCode in setOf("ru", "uk")) {
        val lastTwoDigits = (positiveValue % 100).toInt()
        return 100 + lastTwoDigits
    }

    return when {
        positiveValue > Int.MAX_VALUE -> Int.MAX_VALUE
        else -> positiveValue.toInt()
    }
}
