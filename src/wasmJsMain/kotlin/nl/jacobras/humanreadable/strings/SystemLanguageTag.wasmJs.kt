package nl.jacobras.humanreadable.strings

private fun navigatorLanguage(): String = js("navigator.language")

internal actual fun systemLanguageTag(): String = navigatorLanguage().substringBefore('-')
