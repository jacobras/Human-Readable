package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val EsStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = presentTense(one = "segundo", other = "segundos"),
        minutesLong = presentTense(one = "minuto", other = "minutos"),
        hoursLong = presentTense(one = "hora", other = "horas"),
        daysLong = presentTense(one = "día", other = "días"),
        weeksLong = presentTense(one = "semana", other = "semanas"),
        monthsLong = presentTense(one = "mes", other = "meses"),
        yearsLong = presentTense(one = "año", other = "años"),
        timeAgo = { "hace $it" },
        timeInFuture = { "en $it" },
        now = "ahora",
        today = "hoy",
        yesterday = "ayer",
        tomorrow = "mañana"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)