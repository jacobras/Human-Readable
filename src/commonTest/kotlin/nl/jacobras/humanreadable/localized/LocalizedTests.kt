package nl.jacobras.humanreadable.localized

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import nl.jacobras.humanreadable.HumanReadable
import kotlin.test.Test
import kotlin.time.Duration.Companion.seconds

/**
 * Smoke test that verifies all supported languages have working plural formatting.
 */
class LocalizedTests {

    @Test
    fun cs() {
        LibresSettings.languageCode = "cs"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 sekundy")
    }

    @Test
    fun de() {
        LibresSettings.languageCode = "de"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 Sekunden")
    }

    @Test
    fun en() {
        LibresSettings.languageCode = "en"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 seconds")
    }

    @Test
    fun es() {
        LibresSettings.languageCode = "es"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 segundos")
    }

    @Test
    fun fi() {
        LibresSettings.languageCode = "fi"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 sekuntia")
    }

    @Test
    fun fr() {
        LibresSettings.languageCode = "fr"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 secondes")
    }

    @Test
    fun id() {
        LibresSettings.languageCode = "id"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 detik")
    }

    @Test
    fun it() {
        LibresSettings.languageCode = "it"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 secondi")
    }

    @Test
    fun ja() {
        LibresSettings.languageCode = "ja"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 秒")
    }

    @Test
    fun ko() {
        LibresSettings.languageCode = "ko"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 초")
    }

    @Test
    fun nl() {
        LibresSettings.languageCode = "nl"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 seconden")
    }

    @Test
    fun pl() {
        LibresSettings.languageCode = "pl"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 sekundy")
    }

    @Test
    fun ru() {
        LibresSettings.languageCode = "ru"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 секунды")
    }

    @Test
    fun tr() {
        LibresSettings.languageCode = "tr"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 saniye")
    }

    @Test
    fun uk() {
        LibresSettings.languageCode = "uk"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 секунди")
    }

    @Test
    fun uz() {
        LibresSettings.languageCode = "uz"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 soniya")
    }

    @Test
    fun vi() {
        LibresSettings.languageCode = "vi"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 giây")
    }

    @Test
    fun zh() {
        LibresSettings.languageCode = "zh"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 秒")
    }
}