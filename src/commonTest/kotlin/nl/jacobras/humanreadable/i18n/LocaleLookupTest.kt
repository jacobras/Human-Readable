package nl.jacobras.humanreadable.i18n

import nl.jacobras.humanreadable.HumanReadable
import kotlin.test.Test
import kotlin.test.assertEquals

class LocaleLookupTest {

    private val locales = listOf(
        "zh-Hant-CN",
        "en-US",
        "nl-NL"
    )

    @Test
    fun match() {
        assertEquals("zh-Hant-CN", LocaleMatcher.lookup(locales, "zh-Hant-CN", "default"))
        assertEquals("zh-Hant-CN", LocaleMatcher.lookup(locales, "zh-Hant", "default"))
        assertEquals("zh-Hant-CN", LocaleMatcher.lookup(locales, "zh", "default"))
        assertEquals("en-US", LocaleMatcher.lookup(locales, "en", "default"))
        assertEquals("en-US", LocaleMatcher.lookup(locales, "en-GB", "default"))
        assertEquals("nl-NL", LocaleMatcher.lookup(locales, "nl-NL", "default"))
        assertEquals("nl-NL", LocaleMatcher.lookup(locales, "nl-BE", "default"))
        assertEquals("default", LocaleMatcher.lookup(locales, "unknown", "default"))
    }

    @Test
    fun test() {
        HumanReadable.setLocale("nl")
        assertEquals(HumanLocales.Dutch.locale, HumanReadable.locale)

        HumanReadable.setLocale("nl-BE")
        assertEquals(HumanLocales.Dutch.locale, HumanReadable.locale)

        HumanReadable.setLocale("unknown")
        assertEquals(HumanLocales.Default.locale, HumanReadable.locale)
    }
}