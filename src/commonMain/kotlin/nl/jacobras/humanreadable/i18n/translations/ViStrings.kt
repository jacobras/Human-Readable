package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val ViStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        seconds = presentTense(other = "giây"),
        minutes = presentTense(other = "phút"),
        hours = presentTense(other = "giờ"),
        days = presentTense(other = "ngày"),
        weeks = presentTense(other = "tuần"),
        months = presentTense(other = "tháng"),
        years = presentTense(other = "năm"),
        timeAgo = { "$it trước" },
        timeInFuture = { "sau $it" },
        now = "bây giờ"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)