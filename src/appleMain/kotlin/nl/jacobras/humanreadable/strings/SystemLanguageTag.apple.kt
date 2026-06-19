package nl.jacobras.humanreadable.strings

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

internal actual fun systemLanguageTag(): String = NSLocale.currentLocale.languageCode
