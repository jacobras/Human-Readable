package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.tenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val DeStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = presentTense(one = "Sekunde", other = "Sekunden"),
        minutes = presentTense(one = "Minute", other = "Minuten"),
        hours = presentTense(one = "Stunde", other = "Stunden"),
        days = tenseForms {
            present(one = "Tag", other = "Tage")
            pastOrFuture(other = "Tagen")
        },
        weeks = presentTense(one = "Woche", other = "Wochen"),
        months = tenseForms {
            present(one = "Monat", other = "Monate")
            pastOrFuture(other = "Monaten")
        },
        years = tenseForms {
            present(one = "Jahr", other = "Jahre")
            pastOrFuture(other = "Jahren")
        },
        timeAgo = { "vor $it" },
        timeInFuture = { "in $it" },
        now = "jetzt"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)