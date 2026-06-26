package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val DeStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = presentTense(one = "Sekunde", other = "Sekunden"),
        minutes = presentTense(one = "Minute", other = "Minuten"),
        hours = presentTense(one = "Stunde", other = "Stunden"),
        days = multipleTenses {
            present(one = "Tag", other = "Tage")
            pastOrFuture(other = "Tagen")
        },
        weeks = presentTense(one = "Woche", other = "Wochen"),
        months = multipleTenses {
            present(one = "Monat", other = "Monate")
            pastOrFuture(other = "Monaten")
        },
        years = multipleTenses {
            present(one = "Jahr", other = "Jahre")
            pastOrFuture(other = "Jahren")
        },
        timeAgo = { "vor $it" },
        timeInFuture = { "in $it" },
        now = "jetzt",
        today = "heute",
        yesterday = "gestern",
        tomorrow = "morgen"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)