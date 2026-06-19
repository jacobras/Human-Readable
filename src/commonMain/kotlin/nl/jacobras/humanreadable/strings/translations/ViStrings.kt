package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.otherPlural
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val ViStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::otherPlural,
        seconds = presentTense(other = "giây"),
        minutes = presentTense(other = "phút"),
        hours = presentTense(other = "giờ"),
        days = presentTense(other = "ngày"),
        weeks = presentTense(other = "tuần"),
        months = presentTense(other = "tháng"),
        years = presentTense(other = "năm"),
        timeAgo = { "$it trước" },
        timeInFuture = { "vào $it" },
        now = "bây giờ"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)