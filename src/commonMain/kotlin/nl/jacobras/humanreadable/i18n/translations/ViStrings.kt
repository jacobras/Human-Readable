package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val ViStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        secondsLong = presentTense(other = "giây"),
        minutesLong = presentTense(other = "phút"),
        hoursLong = presentTense(other = "giờ"),
        daysLong = presentTense(other = "ngày"),
        weeksLong = presentTense(other = "tuần"),
        monthsLong = presentTense(other = "tháng"),
        yearsLong = presentTense(other = "năm"),
        timeAgo = { "$it trước" },
        timeInFuture = { "sau $it" },
        now = "bây giờ",
        today = "hôm nay",
        yesterday = "hôm qua",
        tomorrow = "ngày mai"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)