package nl.jacobras.humanreadable.i18n

private fun navigatorLanguage(): String = js("navigator.language")

internal actual fun systemLanguageTag(): String = navigatorLanguage().substringBefore('-')
