package nl.jacobras.humanreadable

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