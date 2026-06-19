package nl.jacobras.humanreadable.strings

import nl.jacobras.humanreadable.RelativeTime

/**
 * The CLDR plural categories. Each supported language maps a count to one of these via its own
 * plural rule (see [Plurals]). See https://www.unicode.org/cldr/charts/45/supplemental/language_plural_rules.html
 */
internal enum class Plural {
    Zero,
    One,
    Two,
    Few,
    Many,
    Other
}

/**
 * The word forms for a single time unit (e.g. "second") in a single language.
 *
 * [present] holds a word per plural category (e.g. [Plural.One] -> "second"). [past] and [future]
 * are optional grammatical-case overrides for relative time (e.g. German "vor 2 Tagen" vs "2 Tage");
 * any category they don't override falls back to [present].
 */
internal data class TenseForms(
    val present: Map<Plural, String>,
    val past: Map<Plural, String> = emptyMap(),
    val future: Map<Plural, String> = emptyMap()
)

/**
 * Convenience builder for a unit that only distinguishes singular and plural (e.g. English).
 */
internal fun oneOther(one: String, other: String): TenseForms =
    TenseForms(present = mapOf(Plural.One to one, Plural.Other to other))

/**
 * Convenience builder for a unit with a single, count-independent form (e.g. Japanese).
 */
internal fun invariant(word: String): TenseForms =
    TenseForms(present = mapOf(Plural.Other to word))

/**
 * All localized text for a single language. English ([nl.jacobras.humanreadable.strings.EnStrings])
 * is the canonical, fully-populated instance; every other language is built with `copy()` and only
 * overrides what differs, so unset fields fall back to English (matching the previous behaviour).
 */
internal data class HumanReadableStrings(
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
    val now: String,
    val groupSeparator: String = ",",
    val decimalSymbol: String = ".",
    val byteSymbol: String = "B",
    val kilobyteSymbol: String = "kB",
    val megabyteSymbol: String = "MB",
    val gigabyteSymbol: String = "GB",
    val terabyteSymbol: String = "TB",
    val meterAbbreviation: String = "m",
    val kilometerAbbreviation: String = "km",
    val feetAbbreviation: String = "ft",
    val mileAbbreviation: String = "mi"
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
