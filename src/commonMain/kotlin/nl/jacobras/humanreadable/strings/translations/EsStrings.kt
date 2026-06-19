package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val EsStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = presentTense(one = "segundo", other = "segundos"),
        minutes = presentTense(one = "minuto", other = "minutos"),
        hours = presentTense(one = "hora", other = "horas"),
        days = presentTense(one = "día", other = "días"),
        weeks = presentTense(one = "semana", other = "semanas"),
        months = presentTense(one = "mes", other = "meses"),
        years = presentTense(one = "año", other = "años"),
        timeAgo = { "hace $it" },
        timeInFuture = { "en $it" },
        now = "ahora"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)