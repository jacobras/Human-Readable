package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val UkStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count ->
            when {
                count % 10 == 1 && count % 100 != 11 -> Plural.One
                count % 10 in 2..4 && count % 100 !in 12..14 -> Plural.Few
                else -> Plural.Many
            }
        },
        secondsLong = multipleTenses {
            present(one = "секунда", few = "секунди", many = "секунд")
            pastOrFuture(one = "секунду")
        },
        minutesLong = multipleTenses {
            present(one = "хвилина", few = "хвилини", many = "хвилин")
            pastOrFuture(one = "хвилину")
        },
        hoursLong = multipleTenses {
            present(one = "година", few = "години", many = "годин")
            pastOrFuture(one = "годину")
        },
        daysLong = presentTense(one = "день", few = "дні", many = "днів"),
        weeksLong = presentTense(one = "тиждень", few = "тижні", many = "тижнів"),
        monthsLong = presentTense(one = "місяць", few = "місяці", many = "місяців"),
        yearsLong = presentTense(one = "рік", few = "роки", many = "років"),
        timeAgo = { "$it тому" },
        timeInFuture = { "через $it" },
        now = "зараз",
        today = "сьогодні",
        yesterday = "вчора",
        tomorrow = "завтра"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)