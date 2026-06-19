package nl.jacobras.humanreadable.strings

import java.util.Locale

internal actual fun systemLanguageTag(): String = Locale.getDefault().language
