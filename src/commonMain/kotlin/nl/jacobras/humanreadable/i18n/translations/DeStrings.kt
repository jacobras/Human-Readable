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
        secondsLong = presentTense(one = "Sekunde", other = "Sekunden"),
        minutesLong = presentTense(one = "Minute", other = "Minuten"),
        hoursLong = presentTense(one = "Stunde", other = "Stunden"),
        daysLong = multipleTenses {
            present(one = "Tag", other = "Tage")
            pastOrFuture(other = "Tagen")
        },
        weeksLong = presentTense(one = "Woche", other = "Wochen"),
        monthsLong = multipleTenses {
            present(one = "Monat", other = "Monate")
            pastOrFuture(other = "Monaten")
        },
        yearsLong = multipleTenses {
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