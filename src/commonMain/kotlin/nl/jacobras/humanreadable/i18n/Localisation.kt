package nl.jacobras.humanreadable.i18n

/**
 * Holds language settings and a reference to the current translation strings.
 */
internal class Localisation {

    private var currentTagAndStrings: Pair<String, HumanReadableStrings>? = null

    /**
     * The requested language tag (e.g. `"en"`, `"fr"`). A language tag with a region, e.g. `"en-US"`, may also
     * be passed in. The region code is ignored.
     *
     * @see languageTag for the actual language tag used, which may differ if the requested one is not supported.
     */
    var requestedLanguageTag = systemLanguageTag()
        set(value) {
            field = value.substringBefore("-")
            currentTagAndStrings = null
        }

    /**
     * The fallback language tag to use if [requestedLanguageTag] is not supported.
     *
     * If this field is changed to a language tag that is not supported, nothing changes.
     */
    var fallbackLanguageTag = "en"
        set(value) {
            if (translations.containsKey(value)) {
                field = value
                currentTagAndStrings = null
            }
        }

    /**
     * The currently used language tag (e.g. `"en"`, `"fr"`).
     */
    val languageTag: String
        get() {
            val (tag, _) = resolve()
            return tag
        }

    /**
     * The current set of translation strings.
     */
    val currentStrings: HumanReadableStrings
        get() {
            val (_, strings) = resolve()
            return strings
        }

    private fun resolve(): Pair<String, HumanReadableStrings> {
        return currentTagAndStrings ?: run {
            val tag = requestedLanguageTag.takeIf { it in translations } ?: fallbackLanguageTag
            val strings = translations[tag] ?: error("Internal error: unsupported language tag $tag")
            (tag to strings).also { currentTagAndStrings = it }
        }
    }
}