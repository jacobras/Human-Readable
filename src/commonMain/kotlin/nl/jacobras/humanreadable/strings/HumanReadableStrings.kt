package nl.jacobras.humanreadable.strings

import nl.jacobras.humanreadable.RelativeTime
import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.TenseForms

/**
 * All localized text for a single language, grouped per type (mirroring the previous per-resource
 * split: time / number / data / distance). English ([EnStrings]) is the canonical, fully-populated
 * instance; every other language overrides only what differs. Each per-type group carries English
 * defaults, so a language that doesn't override a group falls back to English (matching the previous
 * resource fallback).
 */
internal data class HumanReadableStrings(
    val dateTime: DateTimeStrings,
    val number: NumberStrings = NumberStrings(),
    val fileSize: FileSizeStrings = FileSizeStrings(),
    val distance: DistanceStrings = DistanceStrings()
)

/**
 * Relative-time and duration strings: the per-unit word forms plus the relative-time wrappers.
 */
internal data class DateTimeStrings(
    /** Resolves a count to its plural category for this language. */
    val plural: (Int) -> Plural,
    val seconds: TenseForms,
    val minutes: TenseForms,
    val hours: TenseForms,
    val days: TenseForms,
    val weeks: TenseForms,
    val months: TenseForms,
    val years: TenseForms,
    /** Wraps a formatted duration as past relative time, e.g. "3 days ago". */
    val timeAgo: (String) -> String,
    /** Wraps a formatted duration as future relative time, e.g. "in 3 days". */
    val timeInFuture: (String) -> String,
    val now: String
) {

    /**
     * Returns the word for [forms] given the [count] and [relativeTime], applying this language's
     * plural rule and the past/future overrides with a fallback to the present form.
     */
    fun word(forms: TenseForms, count: Int, relativeTime: RelativeTime): String {
        val category = plural(count)
        val override = when (relativeTime) {
            RelativeTime.Past -> forms.past[category]
            RelativeTime.Future -> forms.future[category]
            RelativeTime.Present -> null
        }
        return override
            ?: forms.present[category]
            ?: forms.present[Plural.Other]
            ?: forms.present.values.first()
    }
}

/** Number-formatting symbols. Defaults are English/US ("1,000,000.34"). */
internal data class NumberStrings(
    val groupSeparator: String = ",",
    val decimalSymbol: String = "."
)

/** File-size unit symbols. Defaults are English (B/kB/MB/GB/TB). */
internal data class FileSizeStrings(
    val byteSymbol: String = "B",
    val kilobyteSymbol: String = "kB",
    val megabyteSymbol: String = "MB",
    val gigabyteSymbol: String = "GB",
    val terabyteSymbol: String = "TB"
)

/** Distance unit abbreviations. Defaults are English (m/km/ft/mi). */
internal data class DistanceStrings(
    val meterAbbreviation: String = "m",
    val kilometerAbbreviation: String = "km",
    val feetAbbreviation: String = "ft",
    val mileAbbreviation: String = "mi"
)