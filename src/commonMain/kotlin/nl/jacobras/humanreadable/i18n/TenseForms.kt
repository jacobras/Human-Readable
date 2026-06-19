package nl.jacobras.humanreadable.i18n

/**
 * The word forms for a single unit (e.g. "second") in a single language.
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
 * Builds a map of plural category -> word, one entry per supplied category. Empty parameters are
 * omitted (they are sentinels, never real words).
 */
private fun pluralMap(
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
 * Builds the present-tense word forms for a unit, one entry per supplied plural category.
 * Empty parameters are omitted (they are sentinels, never real words). Use [tenseForms]
 * when past/future grammatical-case overrides are needed.
 */
internal fun presentTense(
    zero: String = "",
    one: String = "",
    two: String = "",
    few: String = "",
    many: String = "",
    other: String = ""
): TenseForms = TenseForms(present = pluralMap(zero, one, two, few, many, other))

/** DSL for building [TenseForms] with present and optional past/future overrides. */
@DslMarker
private annotation class TenseFormsDsl

/**
 * Builder for [TenseForms]. Each method takes one word per plural category (empty args omitted).
 * Use [present] for the base forms and [past]/[future]/[pastOrFuture] for relative-time overrides.
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
        present = pluralMap(zero, one, two, few, many, other)
    }

    fun past(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        past = pluralMap(zero, one, two, few, many, other)
    }

    fun future(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        future = pluralMap(zero, one, two, few, many, other)
    }

    /** Sets both [past] and [future] to the same forms, for languages where they are identical. */
    fun pastOrFuture(
        zero: String = "", one: String = "", two: String = "",
        few: String = "", many: String = "", other: String = ""
    ) {
        val forms = pluralMap(zero, one, two, few, many, other)
        past = forms
        future = forms
    }

    fun build(): TenseForms = TenseForms(present = present, past = past, future = future)
}

/**
 * Builds [TenseForms] for a unit that needs past/future grammatical-case overrides. For
 * present-only units prefer [presentTense].
 */
internal fun tenseForms(block: TenseFormsBuilder.() -> Unit): TenseForms =
    TenseFormsBuilder().apply(block).build()
