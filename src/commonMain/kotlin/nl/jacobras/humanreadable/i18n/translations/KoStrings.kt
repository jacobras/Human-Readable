package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val KoStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { Plural.Other },
        secondsLong = presentTense(other = "초"),
        minutesLong = presentTense(other = "분"),
        hoursLong = presentTense(other = "시간"),
        daysLong = presentTense(other = "일"),
        weeksLong = presentTense(other = "주"),
        monthsLong = presentTense(other = "개월"),
        yearsLong = presentTense(other = "년"),
        secondsShort = presentTense(other = "초"),
        minutesShort = presentTense(other = "분"),
        hoursShort = presentTense(other = "시간"),
        daysShort = presentTense(other = "일"),
        weeksShort = presentTense(other = "주"),
        monthsShort = presentTense(other = "개월"),
        yearsShort = presentTense(other = "년"),
        secondsNarrow = presentTense(other = "초"),
        minutesNarrow = presentTense(other = "분"),
        hoursNarrow = presentTense(other = "시"),
        daysNarrow = presentTense(other = "일"),
        weeksNarrow = presentTense(other = "주"),
        monthsNarrow = presentTense(other = "개월"),
        yearsNarrow = presentTense(other = "년"),
        timeAgo = { "$it 전" },
        timeInFuture = { "$it 후" },
        now = "지금",
        today = "오늘",
        yesterday = "어제",
        tomorrow = "내일",
        lessThan = "미만",
        about = "약"
    )
)