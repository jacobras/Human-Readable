package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val JaStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        secondsLong = presentTense(other = "秒"),
        minutesLong = presentTense(other = "分"),
        hoursLong = presentTense(other = "時間"),
        daysLong = presentTense(other = "日"),
        weeksLong = presentTense(other = "週"),
        monthsLong = presentTense(other = "ヶ月"),
        yearsLong = presentTense(other = "年"),
        secondsShort = presentTense(other = "秒"),
        minutesShort = presentTense(other = "分"),
        hoursShort = presentTense(other = "時間"),
        daysShort = presentTense(other = "日"),
        weeksShort = presentTense(other = "週間"),
        monthsShort = presentTense(other = "か月"),
        yearsShort = presentTense(other = "年"),
        secondsNarrow = presentTense(other = "秒"),
        minutesNarrow = presentTense(other = "分"),
        hoursNarrow = presentTense(other = "時"),
        daysNarrow = presentTense(other = "日"),
        weeksNarrow = presentTense(other = "週"),
        monthsNarrow = presentTense(other = "月"),
        yearsNarrow = presentTense(other = "年"),
        timeAgo = { "${it}前" },
        timeInFuture = { "${it}後" },
        now = "今",
        today = "今日",
        yesterday = "昨日",
        tomorrow = "明日",
        lessThan = "未満",
        about = "約"
    )
)