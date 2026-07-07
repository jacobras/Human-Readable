package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val CsStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count ->
            when (count) {
                1 -> Plural.One
                in 2..4 -> Plural.Few
                else -> Plural.Other
            }
        },
        secondsLong = multipleTenses {
            present(one = "sekunda", few = "sekundy", other = "sekund")
            past(one = "sekundou", few = "sekundami", other = "sekundami")
            future(one = "sekundu", few = "sekundy", other = "sekund")
        },
        minutesLong = multipleTenses {
            present(one = "minuta", few = "minuty", other = "minut")
            past(one = "minutou", few = "minutami", other = "minutami")
            future(one = "minutu", few = "minuty", other = "minut")
        },
        hoursLong = multipleTenses {
            present(one = "hodina", few = "hodiny", other = "hodin")
            past(one = "hodinou", few = "hodinami", other = "hodinami")
            future(one = "hodinu", few = "hodiny", other = "hodin")
        },
        daysLong = multipleTenses {
            present(one = "den", few = "dny", other = "dní")
            past(one = "dnem", few = "dny", other = "dny")
        },
        weeksLong = multipleTenses {
            present(one = "týden", few = "týdny", other = "týdnů")
            past(one = "týdnem", few = "týdny", other = "týdny")
        },
        monthsLong = multipleTenses {
            present(one = "měsíc", few = "měsíce", other = "měsíců")
            past(one = "měsícem", few = "měsíci", other = "měsíci")
        },
        yearsLong = multipleTenses {
            present(one = "rok", few = "roky", other = "let")
            past(one = "rokem", few = "roky", other = "lety")
        },
        secondsShort = presentTense(one = "s"),
        minutesShort = presentTense(one = "min"),
        hoursShort = presentTense(one = "h"),
        daysShort = presentTense(one = "d"),
        weeksShort = presentTense(one = "týd."),
        monthsShort = presentTense(one = "měs."),
        yearsShort = presentTense(one = "r."),
        secondsNarrow = presentTense(one = "s"),
        minutesNarrow = presentTense(one = "min"),
        hoursNarrow = presentTense(one = "h"),
        daysNarrow = presentTense(one = "d"),
        weeksNarrow = presentTense(one = "t"),
        monthsNarrow = presentTense(one = "m"),
        yearsNarrow = presentTense(one = "r"),
        timeAgo = { "před $it" },
        timeInFuture = { "za $it" },
        now = "nyní",
        today = "dnes",
        yesterday = "včera",
        tomorrow = "zítra",
        lessThan = "méně než",
        about = "přibližně"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)