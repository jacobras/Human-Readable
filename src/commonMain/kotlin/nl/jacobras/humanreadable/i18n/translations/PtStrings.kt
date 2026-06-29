package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val PtStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count ->
            when {
                count == 0 || count == 1 -> Plural.One
                count % 1_000_000 == 0 -> Plural.Many
                else -> Plural.Other
            }
        },
        secondsLong = presentTense(one = "segundo", many = "de segundos", other = "segundos"),
        minutesLong = presentTense(one = "minuto", many = "de minutos", other = "minutos"),
        hoursLong = presentTense(one = "hora", many = "de horas", other = "horas"),
        daysLong = presentTense(one = "dia", many = "de dias", other = "dias"),
        weeksLong = presentTense(one = "semana", many = "de semanas", other = "semanas"),
        monthsLong = presentTense(one = "mês", many = "de meses", other = "meses"),
        yearsLong = presentTense(one = "ano", many = "de anos", other = "anos"),
        timeAgo = { "há $it" },
        timeInFuture = { "em $it" },
        now = "agora",
        today = "hoje",
        yesterday = "ontem",
        tomorrow = "amanhã"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)