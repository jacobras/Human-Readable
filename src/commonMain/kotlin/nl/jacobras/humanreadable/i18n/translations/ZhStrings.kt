package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val ZhStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        secondsLong = presentTense(other = "秒"),
        minutesLong = presentTense(other = "分钟"),
        hoursLong = presentTense(other = "小时"),
        daysLong = presentTense(other = "天"),
        weeksLong = presentTense(other = "周"),
        monthsLong = presentTense(other = "个月"),
        yearsLong = presentTense(other = "年"),
        timeAgo = { "${it}之前" },
        timeInFuture = { "${it}之后" },
        now = "现在",
        today = "今天",
        yesterday = "昨天",
        tomorrow = "明天"
    )
)