package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.portuguesePlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

/** Builds a Portuguese unit (one / "de"-plural for millions / other). */
private fun ptUnit(one: String, many: String, other: String) =
    presentTense(one = one, many = many, other = other)

internal val PtStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::portuguesePlural,
        seconds = ptUnit("segundo", "de segundos", "segundos"),
        minutes = ptUnit("minuto", "de minutos", "minutos"),
        hours = ptUnit("hora", "de horas", "horas"),
        days = ptUnit("dia", "de dias", "dias"),
        weeks = ptUnit("semana", "de semanas", "semanas"),
        months = ptUnit("mês", "de meses", "meses"),
        years = ptUnit("ano", "de anos", "anos"),
        timeAgo = { "há $it" },
        timeInFuture = { "em $it" },
        now = "agora"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)