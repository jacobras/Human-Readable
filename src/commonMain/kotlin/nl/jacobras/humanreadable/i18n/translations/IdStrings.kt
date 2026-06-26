package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val IdStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        seconds = presentTense(other = "detik"),
        minutes = presentTense(other = "menit"),
        hours = presentTense(other = "jam"),
        days = presentTense(other = "hari"),
        weeks = presentTense(other = "minggu"),
        months = presentTense(other = "bulan"),
        years = presentTense(other = "tahun"),
        timeAgo = { "$it yang lalu" },
        timeInFuture = { "dalam $it" },
        now = "sekarang",
        today = "hari ini",
        yesterday = "kemarin",
        tomorrow = "besok"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)