package nl.jacobras.humanreadable.localized

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import nl.jacobras.humanreadable.HumanReadable
import kotlin.test.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

/**
 * Smoke test that verifies all supported languages have working plural formatting.
 */
class LocalizedTests {

    private val now: Instant
        get() = Clock.System.now()
    private val oneMinute: Duration
        get() = 1.minutes
    private val oneMinuteAgo: Instant
        get() = now - oneMinute
    private val oneMinuteFromNow: Instant
        get() = now + oneMinute
    private val twoMonths: Duration
        get() = 60.days
    private val twoMonthsAgo: Instant
        get() = now - twoMonths
    private val twoMonthsFromNow: Instant
        get() = now + twoMonths

    @Test
    fun cs() {
        LibresSettings.languageCode = "cs"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 sekundy")
    }

    @Test
    fun de() {
        LibresSettings.languageCode = "de"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 Sekunden")

        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("2 Monate")
        assertThat(HumanReadable.timeAgo(twoMonthsAgo)).isEqualTo("vor 2 Monaten")
        assertThat(HumanReadable.timeAgo(twoMonthsFromNow)).isEqualTo("in 2 Monaten")
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

        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 minuta")
        assertThat(HumanReadable.timeAgo(oneMinuteAgo)).isEqualTo("1 minutę temu")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow)).isEqualTo("za 1 minutę")
    }

    @Test
    fun pt() {
        LibresSettings.languageCode = "pt"
        assertThat(HumanReadable.duration(0.seconds)).isEqualTo("0 segundo")
        assertThat(HumanReadable.duration(1.seconds)).isEqualTo("1 segundo")
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 segundos")
    }

    @Test
    fun ru() {
        LibresSettings.languageCode = "ru"
        assertThat(HumanReadable.duration(2.seconds)).isEqualTo("2 секунды")

        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 минута")
        assertThat(HumanReadable.timeAgo(oneMinuteAgo)).isEqualTo("1 минуту назад")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow)).isEqualTo("через 1 минуту")
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