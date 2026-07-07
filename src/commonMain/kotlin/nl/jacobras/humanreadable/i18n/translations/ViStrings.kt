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
        secondsShort = presentTense(other = "giây"),
        minutesShort = presentTense(other = "phút"),
        hoursShort = presentTense(other = "giờ"),
        daysShort = presentTense(other = "ngày"),
        weeksShort = presentTense(other = "tuần"),
        monthsShort = presentTense(other = "tháng"),
        yearsShort = presentTense(other = "năm"),
        secondsNarrow = presentTense(other = "giây"),
        minutesNarrow = presentTense(other = "phút"),
        hoursNarrow = presentTense(other = "giờ"),
        daysNarrow = presentTense(other = "ngày"),
        weeksNarrow = presentTense(other = "tuần"),
        monthsNarrow = presentTense(other = "tháng"),
        yearsNarrow = presentTense(other = "năm"),
        timeAgo = { "$it trước" },
        timeInFuture = { "sau $it" },
        now = "bây giờ",
        today = "hôm nay",
        yesterday = "hôm qua",
        tomorrow = "ngày mai",
        lessThan = "ít hơn",
        about = "khoảng"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)