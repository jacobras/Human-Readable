package nl.jacobras.humanreadable.i18n

internal fun String.filterLanguagePart(): String {
    return lowercase().substringBefore("-")
}