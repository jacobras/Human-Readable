package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val IdStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        secondsLong = presentTense(other = "detik"),
        minutesLong = presentTense(other = "menit"),
        hoursLong = presentTense(other = "jam"),
        daysLong = presentTense(other = "hari"),
        weeksLong = presentTense(other = "minggu"),
        monthsLong = presentTense(other = "bulan"),
        yearsLong = presentTense(other = "tahun"),
        secondsShort = presentTense(other = "dtk"),
        minutesShort = presentTense(other = "mnt"),
        hoursShort = presentTense(other = "jam"),
        daysShort = presentTense(other = "h"),
        weeksShort = presentTense(other = "mgg"),
        monthsShort = presentTense(other = "bln"),
        yearsShort = presentTense(other = "thn"),
        secondsNarrow = presentTense(other = "dtk"),
        minutesNarrow = presentTense(other = "mnt"),
        hoursNarrow = presentTense(other = "jam"),
        daysNarrow = presentTense(other = "h"),
        weeksNarrow = presentTense(other = "mg"),
        monthsNarrow = presentTense(other = "bln"),
        yearsNarrow = presentTense(other = "thn"),
        timeAgo = { "$it yang lalu" },
        timeInFuture = { "dalam $it" },
        now = "sekarang",
        today = "hari ini",
        yesterday = "kemarin",
        tomorrow = "besok",
        lessThan = "kurang dari",
        about = "sekitar"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)