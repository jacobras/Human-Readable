package nl.jacobras.humanreadable.i18n

internal object LocaleMatcher {

    /**
     * Loosely based on https://www.rfc-editor.org/rfc/rfc4647#section-3.4
     */
    fun lookup(options: List<String>, input: String, default: String): String {
        var search = input

        while (search.contains('-')) {
            options.find { it.startsWith(search) }?.let { return it }

            // Make input more global
            search = search.substringBeforeLast('-')
        }

        return options.find { it.startsWith(search) } ?: default
    }
}