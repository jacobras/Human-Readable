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
        secondsLong = multipleTenses {
            present(one = "секунда", few = "секунды", many = "секунд")
            pastOrFuture(one = "секунду")
        },
        minutesLong = multipleTenses {
            present(one = "минута", few = "минуты", many = "минут")
            pastOrFuture(one = "минуту")
        },
        hoursLong = presentTense(one = "час", few = "часа", many = "часов"),
        daysLong = presentTense(one = "день", few = "дня", many = "дней"),
        weeksLong = multipleTenses {
            present(one = "неделя", few = "недели", many = "недель")
            pastOrFuture(one = "неделю")
        },
        monthsLong = presentTense(one = "месяц", few = "месяца", many = "месяцев"),
        yearsLong = presentTense(one = "год", few = "года", many = "лет"),
        secondsShort = presentTense(one = "с"),
        minutesShort = presentTense(one = "мин"),
        hoursShort = presentTense(one = "ч"),
        daysShort = presentTense(one = "дн"),
        weeksShort = presentTense(one = "нед"),
        monthsShort = presentTense(one = "мес"),
        yearsShort = presentTense(one = "г"),
        secondsNarrow = presentTense(one = "с"),
        minutesNarrow = presentTense(one = "м"),
        hoursNarrow = presentTense(one = "ч"),
        daysNarrow = presentTense(one = "д"),
        weeksNarrow = presentTense(one = "н"),
        monthsNarrow = presentTense(one = "мес"),
        yearsNarrow = presentTense(one = "г"),
        timeAgo = { "$it назад" },
        timeInFuture = { "через $it" },
        now = "сейчас",
        today = "сегодня",
        yesterday = "вчера",
        tomorrow = "завтра",
        lessThan = "менее",
        about = "около"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)