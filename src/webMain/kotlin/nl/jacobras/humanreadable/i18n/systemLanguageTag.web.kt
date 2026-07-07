package nl.jacobras.humanreadable.i18n

import kotlinx.browser.window

private fun navigatorLanguage(): String = window.navigator.language

internal actual fun systemLanguageTag(): String = navigatorLanguage().substringBefore('-')