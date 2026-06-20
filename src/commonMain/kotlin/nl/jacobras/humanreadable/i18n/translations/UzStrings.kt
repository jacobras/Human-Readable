package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val UzStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
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