package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

/**
 * English is the default language that will be used if no better translation is found.
 */
internal val EnStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = presentTense(one = "second", other = "seconds"),
        minutes = presentTense(one = "minute", other = "minutes"),
        hours = presentTense(one = "hour", other = "hours"),
        days = presentTense(one = "day", other = "days"),
        weeks = presentTense(one = "week", other = "weeks"),
        months = presentTense(one = "month", other = "months"),
        years = presentTense(one = "year", other = "years"),
        timeAgo = { "$it ago" },
        timeInFuture = { "in $it" },
        now = "now"
    )
)