package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val PlStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count ->
            when {
                count == 1 -> Plural.One
                count % 10 in 2..4 && count % 100 !in 12..14 -> Plural.Few
                else -> Plural.Many
            }
        },
        secondsLong = multipleTenses {
            present(one = "sekunda", few = "sekundy", many = "sekund")
            pastOrFuture(one = "sekundę")
        },
        minutesLong = multipleTenses {
            present(one = "minuta", few = "minuty", many = "minut")
            pastOrFuture(one = "minutę")
        },
        hoursLong = multipleTenses {
            present(one = "godzina", few = "godziny", many = "godzin")
            pastOrFuture(one = "godzinę")
        },
        daysLong = presentTense(one = "dzień", few = "dni", many = "dni"),
        weeksLong = presentTense(one = "tydzień", few = "tygodnie", many = "tygodni"),
        monthsLong = presentTense(one = "miesiąc", few = "miesiące", many = "miesięcy"),
        yearsLong = presentTense(one = "rok", few = "lata", many = "lat"),
        timeAgo = { "$it temu" },
        timeInFuture = { "za $it" },
        now = "teraz",
        today = "dzisiaj",
        yesterday = "wczoraj",
        tomorrow = "jutro"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)