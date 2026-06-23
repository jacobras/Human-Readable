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
        seconds = multipleTenses {
            present(one = "секунда", few = "секунди", many = "секунд")
            pastOrFuture(one = "секунду")
        },
        minutes = multipleTenses {
            present(one = "хвилина", few = "хвилини", many = "хвилин")
            pastOrFuture(one = "хвилину")
        },
        hours = multipleTenses {
            present(one = "година", few = "години", many = "годин")
            pastOrFuture(one = "годину")
        },
        days = presentTense(one = "день", few = "дні", many = "днів"),
        weeks = presentTense(one = "тиждень", few = "тижні", many = "тижнів"),
        months = presentTense(one = "місяць", few = "місяці", many = "місяців"),
        years = presentTense(one = "рік", few = "роки", many = "років"),
        timeAgo = { "$it тому" },
        timeInFuture = { "через $it" },
        now = "зараз"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)