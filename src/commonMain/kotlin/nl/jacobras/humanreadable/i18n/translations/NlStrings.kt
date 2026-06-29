package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val NlStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = presentTense(one = "seconde", other = "seconden"),
        minutesLong = presentTense(one = "minuut", other = "minuten"),
        hoursLong = presentTense(one = "uur", other = "uur"),
        daysLong = presentTense(one = "dag", other = "dagen"),
        weeksLong = presentTense(one = "week", other = "weken"),
        monthsLong = presentTense(one = "maand", other = "maanden"),
        yearsLong = presentTense(one = "jaar", other = "jaar"),
        timeAgo = { "$it geleden" },
        timeInFuture = { "over $it" },
        now = "nu",
        today = "vandaag",
        yesterday = "gisteren",
        tomorrow = "morgen"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)