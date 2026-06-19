package nl.jacobras.humanreadable.i18n

/**
 * The CLDR plural categories. Each supported language maps a count to one of these via its own
 * plural rule (see [Plurals.kt]). See
 * https://www.unicode.org/cldr/charts/45/supplemental/language_plural_rules.html
 */
internal enum class Plural {
    Zero,
    One,
    Two,
    Few,
    Many,
    Other
}
