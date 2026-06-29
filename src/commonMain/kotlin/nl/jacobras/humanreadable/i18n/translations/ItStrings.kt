package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val ItStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = presentTense(one = "secondo", other = "secondi"),
        minutesLong = presentTense(one = "minuto", other = "minuti"),
        hoursLong = presentTense(one = "ora", other = "ore"),
        daysLong = presentTense(one = "giorno", other = "giorni"),
        weeksLong = presentTense(one = "settimana", other = "settimane"),
        monthsLong = presentTense(one = "mese", other = "mesi"),
        yearsLong = presentTense(one = "anno", other = "anni"),
        timeAgo = { "$it fa" },
        timeInFuture = { "tra $it" },
        now = "adesso",
        today = "oggi",
        yesterday = "ieri",
        tomorrow = "domani"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)