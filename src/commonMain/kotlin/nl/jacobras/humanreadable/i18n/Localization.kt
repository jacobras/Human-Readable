package nl.jacobras.humanreadable.i18n

/**
 * A tiny, content-free locale registry: maps language tags to translation sets of type [T] and
 * tracks the currently active tag. Replaces the third-party Lyricist runtime.
 *
 * The initial tag is the detected system language when it is supported, otherwise English. It can be
 * changed at runtime via [languageTag]; [current] always resolves to the active translation set,
 * falling back to [fallback] for an unsupported tag.
 */
internal class Localization<T>(
    private val translations: Map<String, T>,
    private val fallback: T
) {
    var languageTag: String = systemLanguageTag().takeIf(translations::containsKey) ?: "en"

    val current: T
        get() = translations[languageTag] ?: fallback
}
