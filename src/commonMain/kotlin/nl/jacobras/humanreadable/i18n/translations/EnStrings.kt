package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense

/**
 * English is the default language that will be used if no better translation is found.
 */
internal val EnStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },

        secondsLong = presentTense(one = "second", other = "seconds"),
        secondsShort = presentTense(one = "sec", other = "sec"),
        secondsNarrow = presentTense(one = "s"),

        minutesLong = presentTense(one = "minute", other = "minutes"),
        minutesShort = presentTense(one = "min"),
        minutesNarrow = presentTense(one = "m"),

        hoursLong = presentTense(one = "hour", other = "hours"),
        hoursShort = presentTense(one = "hr"),
        hoursNarrow = presentTense(one = "h"),

        daysLong = presentTense(one = "day", other = "days"),
        daysShort = presentTense(one = "day", other = "days"),
        daysNarrow = presentTense(one = "d"),

        weeksLong = presentTense(one = "week", other = "weeks"),
        weeksShort = presentTense(one = "wk", other = "wks"),
        weeksNarrow = presentTense(one = "w"),

        monthsLong = presentTense(one = "month", other = "months"),
        monthsShort = presentTense(one = "mth", other = "mths"),
        monthsNarrow = presentTense(one = "m"),

        yearsLong = presentTense(one = "year", other = "years"),
        yearsShort = presentTense(one = "yr", other = "yrs"),
        yearsNarrow = presentTense(one = "y"),

        timeAgo = { "$it ago" },
        timeInFuture = { "in $it" },
        now = "now",
        today = "today",
        yesterday = "yesterday",
        tomorrow = "tomorrow",
        lessThan = "less than",
        about = "about"
    )
)