package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.otherPlural
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val IdStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::otherPlural,
        seconds = presentTense(other = "detik"),
        minutes = presentTense(other = "menit"),
        hours = presentTense(other = "jam"),
        days = presentTense(other = "hari"),
        weeks = presentTense(other = "minggu"),
        months = presentTense(other = "bulan"),
        years = presentTense(other = "tahun"),
        timeAgo = { "$it yang lalu" },
        timeInFuture = { "dalam $it" },
        now = "sekarang"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)