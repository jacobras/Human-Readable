package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val UzStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = presentTense(other = "soniya"),
        minutes = presentTense(other = "daqiqa"),
        hours = presentTense(other = "soat"),
        days = presentTense(other = "kun"),
        weeks = presentTense(other = "hafta"),
        months = presentTense(other = "oy"),
        years = presentTense(other = "yil"),
        timeAgo = { "$it oldin" },
        timeInFuture = { "$it keyin" },
        now = "hozir"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)