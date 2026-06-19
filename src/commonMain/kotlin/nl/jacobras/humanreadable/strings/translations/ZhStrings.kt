package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.otherPlural
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings

internal val ZhStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::otherPlural,
        seconds = presentTense(other = "秒"),
        minutes = presentTense(other = "分钟"),
        hours = presentTense(other = "小时"),
        days = presentTense(other = "天"),
        weeks = presentTense(other = "周"),
        months = presentTense(other = "个月"),
        years = presentTense(other = "年"),
        timeAgo = { "${it}之前" },
        timeInFuture = { "${it}之后" },
        now = "现在"
    )
)