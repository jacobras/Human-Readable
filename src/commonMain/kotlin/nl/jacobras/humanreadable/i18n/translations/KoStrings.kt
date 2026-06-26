package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val KoStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        seconds = presentTense(other = "초"),
        minutes = presentTense(other = "분"),
        hours = presentTense(other = "시간"),
        days = presentTense(other = "일"),
        weeks = presentTense(other = "주"),
        months = presentTense(other = "개월"),
        years = presentTense(other = "년"),
        timeAgo = { "$it 전" },
        timeInFuture = { "$it 후" },
        now = "지금",
        today = "오늘",
        yesterday = "어제",
        tomorrow = "내일"
    )
)