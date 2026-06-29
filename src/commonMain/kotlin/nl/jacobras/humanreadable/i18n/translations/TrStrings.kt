package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val TrStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = presentTense(other = "saniye"),
        minutesLong = presentTense(other = "dakika"),
        hoursLong = presentTense(other = "saat"),
        daysLong = presentTense(other = "gün"),
        weeksLong = presentTense(other = "hafta"),
        monthsLong = presentTense(other = "ay"),
        yearsLong = presentTense(other = "yıl"),
        timeAgo = { "$it önce" },
        timeInFuture = { "$it sonra" },
        now = "şimdi",
        today = "bugün",
        yesterday = "dün",
        tomorrow = "yarın"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)