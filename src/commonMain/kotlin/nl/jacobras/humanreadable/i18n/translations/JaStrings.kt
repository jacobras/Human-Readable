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
        timeAgo = { "${it}前" },
        timeInFuture = { "${it}後" },
        now = "今",
        today = "今日",
        yesterday = "昨日",
        tomorrow = "明日"
    )
)