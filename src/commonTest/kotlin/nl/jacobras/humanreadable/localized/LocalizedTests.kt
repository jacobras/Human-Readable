package nl.jacobras.humanreadable.localized

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import nl.jacobras.humanreadable.HumanReadable
import kotlin.test.Test
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

/**
 * Smoke test that verifies all supported languages have working plural formatting.
 */
class LocalizedTests {

    private val now: Instant = Clock.System.now()
    private val twoSeconds = 2.seconds
    private val twoSecondsAgo = now - twoSeconds
    private val twoSecondsFromNow = now + twoSeconds
    private val oneMinute = 1.minutes
    private val oneMinuteAgo = now - oneMinute
    private val oneMinuteFromNow = now + oneMinute
    private val oneHour = 60.minutes
    private val oneHourAgo = now - oneHour
    private val oneHourFromNow = now + oneHour
    private val oneDay = 1.days
    private val oneDayAgo = now - oneDay
    private val oneDayFromNow = now + oneDay
    private val oneWeek = 7.days
    private val oneWeekAgo = now - oneWeek
    private val oneWeekFromNow = now + oneWeek
    private val twoMonths = 60.days
    private val twoMonthsAgo = now - twoMonths
    private val twoMonthsFromNow = now + twoMonths
    private val oneYear = 365.days
    private val oneYearAgo = now - oneYear
    private val oneYearFromNow = now + oneYear

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
        assertThat(HumanReadable.timeAgo(twoMonthsAgo, baseInstant = now)).isEqualTo("vor 2 Monaten")
        assertThat(HumanReadable.timeAgo(twoMonthsFromNow, baseInstant = now)).isEqualTo("in 2 Monaten")
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
    fun kk() {
        LibresSettings.languageCode = "kk"
        assertThat(HumanReadable.timeAgo(now)).isEqualTo("қазір")
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 секунд")
        assertThat(HumanReadable.timeAgo(twoSecondsAgo, baseInstant = now)).isEqualTo("2 секунд бұрын")
        assertThat(HumanReadable.timeAgo(twoSecondsFromNow, baseInstant = now)).isEqualTo("2 секундтан кейін")
        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 минут")
        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 минут бұрын")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("1 минуттан кейін")
        assertThat(HumanReadable.duration(oneHour)).isEqualTo("1 сағат")
        assertThat(HumanReadable.timeAgo(oneHourAgo, baseInstant = now)).isEqualTo("1 сағат бұрын")
        assertThat(HumanReadable.timeAgo(oneHourFromNow, baseInstant = now)).isEqualTo("1 сағаттан кейін")
        assertThat(HumanReadable.duration(oneDay)).isEqualTo("1 күн")
        assertThat(HumanReadable.timeAgo(oneDayAgo, baseInstant = now)).isEqualTo("1 күн бұрын")
        assertThat(HumanReadable.timeAgo(oneDayFromNow, baseInstant = now)).isEqualTo("1 күннен кейін")
        assertThat(HumanReadable.duration(oneWeek)).isEqualTo("1 апта")
        assertThat(HumanReadable.timeAgo(oneWeekAgo, baseInstant = now)).isEqualTo("1 апта бұрын")
        assertThat(HumanReadable.timeAgo(oneWeekFromNow, baseInstant = now)).isEqualTo("1 аптадан кейін")
        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("2 ай")
        assertThat(HumanReadable.timeAgo(twoMonthsAgo, baseInstant = now)).isEqualTo("2 ай бұрын")
        assertThat(HumanReadable.timeAgo(twoMonthsFromNow, baseInstant = now)).isEqualTo("2 айдан кейін")
        assertThat(HumanReadable.duration(oneYear)).isEqualTo("1 жыл")
        assertThat(HumanReadable.timeAgo(oneYearAgo, baseInstant = now)).isEqualTo("1 жыл бұрын")
        assertThat(HumanReadable.timeAgo(oneYearFromNow, baseInstant = now)).isEqualTo("1 жылдан кейін")
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
        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 minutę temu")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("za 1 minutę")
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
        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 минуту назад")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("через 1 минуту")
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