package nl.jacobras.humanreadable.i18n

import java.util.Locale

internal actual fun systemLanguageTag(): String = Locale.getDefault().language