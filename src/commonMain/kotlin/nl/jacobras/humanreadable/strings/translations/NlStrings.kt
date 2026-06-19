package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val NlStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = presentTense(one = "seconde", other = "seconden"),
        minutes = presentTense(one = "minuut", other = "minuten"),
        hours = presentTense(one = "uur", other = "uur"),
        days = presentTense(one = "dag", other = "dagen"),
        weeks = presentTense(one = "week", other = "weken"),
        months = presentTense(one = "maand", other = "maanden"),
        years = presentTense(one = "jaar", other = "jaar"),
        timeAgo = { "$it geleden" },
        timeInFuture = { "over $it" },
        now = "nu"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)