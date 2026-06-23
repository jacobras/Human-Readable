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
        seconds = presentTense(one = "segundo", many = "de segundos", other = "segundos"),
        minutes = presentTense(one = "minuto", many = "de minutos", other = "minutos"),
        hours = presentTense(one = "hora", many = "de horas", other = "horas"),
        days = presentTense(one = "dia", many = "de dias", other = "dias"),
        weeks = presentTense(one = "semana", many = "de semanas", other = "semanas"),
        months = presentTense(one = "mês", many = "de meses", other = "meses"),
        years = presentTense(one = "ano", many = "de anos", other = "anos"),
        timeAgo = { "há $it" },
        timeInFuture = { "em $it" },
        now = "agora"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)