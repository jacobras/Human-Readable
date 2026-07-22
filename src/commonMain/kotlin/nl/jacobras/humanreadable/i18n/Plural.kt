package nl.jacobras.humanreadable.i18n

/**
 * CLDR plural categories.
 *
 * See [Unicode Plural Rules](https://www.unicode.org/cldr/charts/48/supplemental/language_plural_rules.html).
 */
internal enum class Plural {
    Zero,
    One,
    Two,
    Few,
    Many,
    Other
}