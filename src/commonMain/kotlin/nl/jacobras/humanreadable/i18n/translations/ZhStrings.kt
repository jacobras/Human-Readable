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
        secondsShort = presentTense(other = "秒"),
        minutesShort = presentTense(other = "分钟"),
        hoursShort = presentTense(other = "小时"),
        daysShort = presentTense(other = "天"),
        weeksShort = presentTense(other = "周"),
        monthsShort = presentTense(other = "个月"),
        yearsShort = presentTense(other = "年"),
        secondsNarrow = presentTense(other = "秒"),
        minutesNarrow = presentTense(other = "分"),
        hoursNarrow = presentTense(other = "时"),
        daysNarrow = presentTense(other = "天"),
        weeksNarrow = presentTense(other = "周"),
        monthsNarrow = presentTense(other = "月"),
        yearsNarrow = presentTense(other = "年"),
        timeAgo = { "${it}之前" },
        timeInFuture = { "${it}之后" },
        now = "现在",
        today = "今天",
        yesterday = "昨天",
        tomorrow = "明天",
        lessThan = "少于",
        about = "大约"
    )
)