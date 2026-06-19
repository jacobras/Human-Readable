package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.eastSlavicPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val UkStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::eastSlavicPlural,
        seconds = presentTense(one = "секунду", few = "секунди", many = "секунд"),
        minutes = presentTense(one = "хвилину", few = "хвилини", many = "хвилин"),
        hours = presentTense(one = "годину", few = "години", many = "годин"),
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