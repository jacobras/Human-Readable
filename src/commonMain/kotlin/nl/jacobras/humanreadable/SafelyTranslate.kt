package nl.jacobras.humanreadable

import io.github.skeptick.libres.strings.VoidPluralString

/**
 * Prevents crashing consumer app on a translation issue.
 */
internal fun safelyTranslate(block: () -> String): String {
    return try {
        block()
    } catch (e: IllegalStateException) {
        "Translation error: ${e.message ?: "IllegalStateException"}"
    }
}

/**
 * @return `null` if the given resource doesn't exist in the current locale.
 */
internal fun VoidPluralString.optionallyFormat(number: Int): String? {
    return try {
        format(number).takeIf { it.isNotEmpty() }
    } catch (e: IllegalStateException) {
        return null
    }
}