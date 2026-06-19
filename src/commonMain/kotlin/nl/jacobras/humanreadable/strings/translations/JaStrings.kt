package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.otherPlural
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings

internal val JaStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::otherPlural,
        seconds = presentTense(other = "秒"),
        minutes = presentTense(other = "分"),
        hours = presentTense(other = "時間"),
        days = presentTense(other = "日"),
        weeks = presentTense(other = "週"),
        months = presentTense(other = "ヶ月"),
        years = presentTense(other = "年"),
        timeAgo = { "${it}前" },
        timeInFuture = { "${it}後" },
        now = "今"
    )
)