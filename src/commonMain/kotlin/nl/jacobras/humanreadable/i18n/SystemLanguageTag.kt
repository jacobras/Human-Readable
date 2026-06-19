package nl.jacobras.humanreadable.i18n

/**
 * Returns the current platform language tag (e.g. "en", "nl"), used to pick the initial language so
 * the library localizes automatically without configuration.
 */
internal expect fun systemLanguageTag(): String
