@file:Suppress("LongParameterList")

package nl.jacobras.humanreadable.i18n

/**
 * The word forms for a single unit (e.g. "minute") in a single language.
 *
 * @property present The word forms for the present tense. E.g. "minute" for [Plural.One]
 * and "minutes" for [Plural.Other].
 * @property past The word forms for the past tense, if they differ from [present].
 * @property future The word forms for the future tense, if they differ from [present].
 */
internal data class TenseForms(
    val present: Map<Plural, String>,
    val past: Map<Plural, String> = emptyMap(),
    val future: Map<Plural, String> = emptyMap()
)

/**
 * Builds a map of plural category -> word entries, ignoring empty ones.
 */
private fun buildMap(
    zero: String = "",
    one: String = "",
    two: String = "",
    few: String = "",
    many: String = "",
    other: String = ""
): Map<Plural, String> = buildMap {
    if (zero.isNotEmpty()) put(Plural.Zero, zero)
    if (one.isNotEmpty()) put(Plural.One, one)
    if (two.isNotEmpty()) put(Plural.Two, two)
    if (few.isNotEmpty()) put(Plural.Few, few)
    if (many.isNotEmpty()) put(Plural.Many, many)
    if (other.isNotEmpty()) put(Plural.Other, other)
}

/**
 * Shortcut for languages that don't need past/future grammatical-case overrides.
 *
 * - If there's no difference between the different categories, just fill [one].
 * - Use [multipleTenses] when past/future grammatical-case overrides are needed.
 */
internal fun presentTense(
    zero: String = "",
    one: String = "",
    two: String = "",
    few: String = "",
    many: String = "",
    other: String = ""
): TenseForms = TenseForms(present = buildMap(zero, one, two, few, many, other))

/**
 * Builds [TenseForms] for a unit that needs past/future grammatical-case overrides. For
 * present-only units prefer [presentTense].
 */
internal fun multipleTenses(block: TenseFormsBuilder.() -> Unit): TenseForms {
    return TenseFormsBuilder().apply(block).build()
}

/** DSL for building [TenseForms] with present and optional past/future overrides. */
@DslMarker
private annotation class TenseFormsDsl

/**
 * Builder for [TenseForms].
 *
 * - Use [present] to set the base forms.
 * - Use [past]/[future] to override the past/future forms.
 *
 * For languages where past/future are identical (but different from present), use [pastOrFuture].
 */
@TenseFormsDsl
internal class TenseFormsBuilder {
    private var present: Map<Plural, String> = emptyMap()
    private var past: Map<Plural, String> = emptyMap()
    private var future: Map<Plural, String> = emptyMap()

    fun present(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        present = buildMap(zero, one, two, few, many, other)
    }

    fun past(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        past = buildMap(zero, one, two, few, many, other)
    }

    fun future(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        future = buildMap(zero, one, two, few, many, other)
    }

    /**
     * Sets both [past] and [future] to the same forms, for languages where they are identical.
     */
    fun pastOrFuture(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        val forms = buildMap(zero, one, two, few, many, other)
        past = forms
        future = forms
    }

    fun build(): TenseForms = TenseForms(present = present, past = past, future = future)
}