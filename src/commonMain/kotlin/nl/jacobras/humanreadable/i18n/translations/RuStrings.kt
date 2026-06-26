package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val RuStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count ->
            when {
                count % 10 == 1 && count % 100 != 11 -> Plural.One
                count % 10 in 2..4 && count % 100 !in 12..14 -> Plural.Few
                else -> Plural.Many
            }
        },
        seconds = multipleTenses {
            present(one = "секунда", few = "секунды", many = "секунд")
            pastOrFuture(one = "секунду")
        },
        minutes = multipleTenses {
            present(one = "минута", few = "минуты", many = "минут")
            pastOrFuture(one = "минуту")
        },
        hours = presentTense(one = "час", few = "часа", many = "часов"),
        days = presentTense(one = "день", few = "дня", many = "дней"),
        weeks = multipleTenses {
            present(one = "неделя", few = "недели", many = "недель")
            pastOrFuture(one = "неделю")
        },
        months = presentTense(one = "месяц", few = "месяца", many = "месяцев"),
        years = presentTense(one = "год", few = "года", many = "лет"),
        timeAgo = { "$it назад" },
        timeInFuture = { "через $it" },
        now = "сейчас",
        today = "сегодня",
        yesterday = "вчера",
        tomorrow = "завтра"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)