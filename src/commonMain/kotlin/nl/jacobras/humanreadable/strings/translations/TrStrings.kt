package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val TrStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
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