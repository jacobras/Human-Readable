package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val ItStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = presentTense(one = "secondo", other = "secondi"),
        minutes = presentTense(one = "minuto", other = "minuti"),
        hours = presentTense(one = "ora", other = "ore"),
        days = presentTense(one = "giorno", other = "giorni"),
        weeks = presentTense(one = "settimana", other = "settimane"),
        months = presentTense(one = "mese", other = "mesi"),
        years = presentTense(one = "anno", other = "anni"),
        timeAgo = { "$it fa" },
        timeInFuture = { "tra $it" },
        now = "adesso",
        today = "oggi",
        yesterday = "ieri",
        tomorrow = "domani"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)