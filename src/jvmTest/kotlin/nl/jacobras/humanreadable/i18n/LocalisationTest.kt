package nl.jacobras.humanreadable.i18n

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import java.util.*
import kotlin.test.Test

class LocalisationTest {

    @BeforeEach
    fun setup() {
        Locale.setDefault(Locale.ENGLISH)
    }

    @Test
    fun `languageTag defaults to system language`() {
        // Given a system language of French
        Locale.setDefault(Locale.FRANCE)

        val localisation = Localisation()

        // Then the language tag should be French
        assertThat(localisation.languageTag).isEqualTo("fr")
    }

    @Test
    fun `languageTag falls back to English (by default) if system language is not supported`() {
        // Given a system language of a language that is not supported
        Locale.setDefault(Locale.forLanguageTag("xx-XX"))

        val localisation = Localisation()

        // Then the language tag should be English (the default fallback)
        assertThat(localisation.languageTag).isEqualTo("en")
    }

    @Test
    fun `setting requested language tag`() {
        val localisation = Localisation()
        localisation.requestedLanguageTag = "de"

        assertThat(localisation.languageTag).isEqualTo("de")
    }

    @Test
    fun `setting requested language tag with region`() {
        val localisation = Localisation()
        localisation.requestedLanguageTag = "fr-FR"

        assertThat(localisation.languageTag).isEqualTo("fr")
    }

    @Test
    fun `languageTag falls back to a custom fallback if system language is not supported`() {
        // Given a system language of a language that is not supported
        Locale.setDefault(Locale.forLanguageTag("xx-XX"))

        // and the fallback language tag is set to French
        val localisation = Localisation()
        localisation.fallbackLanguageTag = "fr"

        // Then the used language tag should be French
        assertThat(localisation.languageTag).isEqualTo("fr")
    }

    @Test
    fun `setting a non-supported fallback language tag changes nothing`() {
        val localisation = Localisation()
        localisation.fallbackLanguageTag = "xx"

        // Then the used language tag stays English (the default fallback)
        assertThat(localisation.languageTag).isEqualTo("en")
    }
}