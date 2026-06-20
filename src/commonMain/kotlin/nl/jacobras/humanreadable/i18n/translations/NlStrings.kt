package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val NlStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
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