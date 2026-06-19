package nl.jacobras.humanreadable.i18n

/**
 * CLDR plural rules per language. Ported from the previous `extendLibresPlurals()` workaround and
 * the plural rules Libres applied for the remaining languages, so output stays identical.
 *
 * Only integer counts are passed in (never fractions), so rules are simplified accordingly.
 */

/** English-like rule (one for 1, otherwise other). Also used for de, es, it, tr, el, nl, kk. */
internal fun defaultPlural(count: Int): Plural =
    if (count == 1) Plural.One else Plural.Other

/** Languages without grammatical number (id, ja, ko, vi, zh): always [Plural.Other]. */
internal fun otherPlural(count: Int): Plural = Plural.Other

/** French: 0 and 1 are "one", everything else "other". */
internal fun frenchPlural(count: Int): Plural =
    if (count == 0 || count == 1) Plural.One else Plural.Other

/** Czech. */
internal fun czechPlural(count: Int): Plural = when (count) {
    1 -> Plural.One
    in 2..4 -> Plural.Few
    else -> Plural.Other
}

/** Polish. */
internal fun polishPlural(count: Int): Plural = when {
    count == 1 -> Plural.One
    count % 10 in 2..4 && count % 100 !in 12..14 -> Plural.Few
    else -> Plural.Many
}

/** Portuguese. */
internal fun portuguesePlural(count: Int): Plural = when {
    count == 0 || count == 1 -> Plural.One
    count % 1_000_000 == 0 -> Plural.Many
    else -> Plural.Other
}

/** Arabic. */
internal fun arabicPlural(count: Int): Plural = when {
    count == 0 -> Plural.Zero
    count == 1 -> Plural.One
    count == 2 -> Plural.Two
    count % 100 in 3..10 -> Plural.Few
    count % 100 in 11..99 -> Plural.Many
    else -> Plural.Other
}

/** Russian and Ukrainian share the same East-Slavic rule (one/few/many for integers). */
internal fun eastSlavicPlural(count: Int): Plural = when {
    count % 10 == 1 && count % 100 != 11 -> Plural.One
    count % 10 in 2..4 && count % 100 !in 12..14 -> Plural.Few
    else -> Plural.Many
}
