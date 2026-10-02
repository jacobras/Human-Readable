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
        secondsShort = presentTense(other = "sn."),
        minutesShort = presentTense(other = "dk."),
        hoursShort = presentTense(other = "sa."),
        daysShort = presentTense(other = "g"),
        weeksShort = presentTense(other = "hf."),
        monthsShort = presentTense(other = "ay"),
        yearsShort = presentTense(other = "yıl"),
        secondsNarrow = presentTense(other = "sn"),
        minutesNarrow = presentTense(other = "dk"),
        hoursNarrow = presentTense(other = "sa"),
        daysNarrow = presentTense(other = "g"),
        weeksNarrow = presentTense(other = "h"),
        monthsNarrow = presentTense(other = "a"),
        yearsNarrow = presentTense(other = "y"),
        timeAgo = { "$it önce" },
        timeInFuture = { "$it sonra" },
        now = "şimdi",
        today = "bugün",
        yesterday = "dün",
        tomorrow = "yarın",
        lessThan = "daha az",
        about = "yaklaşık"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)