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
        secondsShort = presentTense(one = "sec"),
        minutesShort = presentTense(one = "min"),
        hoursShort = presentTense(one = "uur"),
        daysShort = presentTense(one = "d"),
        weeksShort = presentTense(one = "wk"),
        monthsShort = presentTense(one = "mnd"),
        yearsShort = presentTense(one = "jr"),
        secondsNarrow = presentTense(one = "s"),
        minutesNarrow = presentTense(one = "m"),
        hoursNarrow = presentTense(one = "u"),
        daysNarrow = presentTense(one = "d"),
        weeksNarrow = presentTense(one = "w"),
        monthsNarrow = presentTense(one = "mnd"),
        yearsNarrow = presentTense(one = "j"),
        timeAgo = { "$it geleden" },
        timeInFuture = { "over $it" },
        now = "nu",
        today = "vandaag",
        yesterday = "gisteren",
        tomorrow = "morgen",
        lessThan = "minder dan",
        about = "ongeveer"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)