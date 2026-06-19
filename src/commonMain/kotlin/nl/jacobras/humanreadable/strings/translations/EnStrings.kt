package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.DistanceStrings
import nl.jacobras.humanreadable.strings.FileSizeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

/**
 * English is the canonical, fully-populated set of strings. Every per-type group's English values
 * are the defaults on [NumberStrings] / [FileSizeStrings] / [DistanceStrings], so other languages
 * only override what differs (matching the previous resource fallback).
 */
internal val EnStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
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