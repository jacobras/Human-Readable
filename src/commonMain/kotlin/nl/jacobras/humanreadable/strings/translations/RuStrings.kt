package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.eastSlavicPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.tenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val RuStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::eastSlavicPlural,
        seconds = tenseForms {
            present(one = "секунда", few = "секунды", many = "секунд")
            pastOrFuture(one = "секунду")
        },
        minutes = tenseForms {
            present(one = "минута", few = "минуты", many = "минут")
            pastOrFuture(one = "минуту")
        },
        hours = presentTense(one = "час", few = "часа", many = "часов"),
        days = presentTense(one = "день", few = "дня", many = "дней"),
        weeks = tenseForms {
            present(one = "неделя", few = "недели", many = "недель")
            pastOrFuture(one = "неделю")
        },
        months = presentTense(one = "месяц", few = "месяца", many = "месяцев"),
        years = presentTense(one = "год", few = "года", many = "лет"),
        timeAgo = { "$it назад" },
        timeInFuture = { "через $it" },
        now = "сейчас"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)