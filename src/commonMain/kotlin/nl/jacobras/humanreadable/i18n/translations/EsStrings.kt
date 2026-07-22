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
        secondsShort = presentTense(one = "s"),
        minutesShort = presentTense(one = "min"),
        hoursShort = presentTense(one = "h"),
        daysShort = presentTense(one = "d"),
        weeksShort = presentTense(one = "sem."),
        monthsShort = presentTense(one = "m."),
        yearsShort = presentTense(one = "a"),
        secondsNarrow = presentTense(one = "s"),
        minutesNarrow = presentTense(one = "min"),
        hoursNarrow = presentTense(one = "h"),
        daysNarrow = presentTense(one = "d"),
        weeksNarrow = presentTense(one = "sem."),
        monthsNarrow = presentTense(one = "m."),
        yearsNarrow = presentTense(one = "a"),
        timeAgo = { "hace $it" },
        timeInFuture = { "en $it" },
        now = "ahora",
        today = "hoy",
        yesterday = "ayer",
        tomorrow = "mañana",
        lessThan = "menos de",
        about = "aprox."
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)