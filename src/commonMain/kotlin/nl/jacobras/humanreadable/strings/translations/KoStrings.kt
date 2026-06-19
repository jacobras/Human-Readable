package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.otherPlural
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings

internal val KoStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::otherPlural,
        seconds = presentTense(other = "초"),
        minutes = presentTense(other = "분"),
        hours = presentTense(other = "시"),
        days = presentTense(other = "일"),
        weeks = presentTense(other = "주"),
        months = presentTense(other = "월"),
        years = presentTense(other = "년"),
        timeAgo = { "$it 전" },
        timeInFuture = { "$it 후" },
        now = "지금"
    )
)