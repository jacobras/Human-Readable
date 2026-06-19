package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val ItStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = presentTense(one = "secondo", other = "secondi"),
        minutes = presentTense(one = "minuto", other = "minuti"),
        hours = presentTense(one = "ora", other = "ore"),
        days = presentTense(one = "giorno", other = "giorni"),
        weeks = presentTense(one = "settimana", other = "settimane"),
        months = presentTense(one = "mese", other = "mesi"),
        years = presentTense(one = "anno", other = "anni"),
        timeAgo = { "$it fa" },
        timeInFuture = { "tra $it" },
        now = "adesso"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)