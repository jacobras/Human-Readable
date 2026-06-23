package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val ZhStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
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