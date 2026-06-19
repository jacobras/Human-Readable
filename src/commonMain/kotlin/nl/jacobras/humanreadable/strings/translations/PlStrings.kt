package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.polishPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.tenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val PlStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::polishPlural,
        seconds = tenseForms {
            present(one = "sekunda", few = "sekundy", many = "sekund")
            pastOrFuture(one = "sekundę")
        },
        minutes = tenseForms {
            present(one = "minuta", few = "minuty", many = "minut")
            pastOrFuture(one = "minutę")
        },
        hours = tenseForms {
            present(one = "godzina", few = "godziny", many = "godzin")
            pastOrFuture(one = "godzinę")
        },
        days = presentTense(one = "dzień", few = "dni", many = "dni"),
        weeks = presentTense(one = "tydzień", few = "tygodnie", many = "tygodni"),
        months = presentTense(one = "miesiąc", few = "miesiące", many = "miesięcy"),
        years = presentTense(one = "rok", few = "lata", many = "lat"),
        timeAgo = { "$it temu" },
        timeInFuture = { "za $it" },
        now = "teraz"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)