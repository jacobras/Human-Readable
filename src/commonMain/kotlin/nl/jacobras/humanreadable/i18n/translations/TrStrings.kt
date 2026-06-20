package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val TrStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = presentTense(other = "saniye"),
        minutes = presentTense(other = "dakika"),
        hours = presentTense(other = "saat"),
        days = presentTense(other = "gün"),
        weeks = presentTense(other = "hafta"),
        months = presentTense(other = "ay"),
        years = presentTense(other = "yıl"),
        timeAgo = { "$it önce" },
        timeInFuture = { "$it sonra" },
        now = "şimdi"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)