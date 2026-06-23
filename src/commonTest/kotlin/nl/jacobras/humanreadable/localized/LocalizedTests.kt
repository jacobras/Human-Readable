package nl.jacobras.humanreadable.localized

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.jacobras.humanreadable.DistanceUnit
import nl.jacobras.humanreadable.HumanReadable
import kotlin.test.Test
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Smoke test that verifies all supported languages have working plural formatting.
 */
@OptIn(ExperimentalTime::class)
class LocalizedTests {

    private val now: Instant = Clock.System.now()
    private val zeroSeconds = 0.seconds
    private val oneSecond = 1.seconds
    private val oneSecondFromNow = now + oneSecond
    private val twoSeconds = 2.seconds
    private val twoSecondsAgo = now - twoSeconds
    private val twoSecondsFromNow = now + twoSeconds
    private val threeSeconds = 3.seconds
    private val elevenSeconds = 11.seconds
    private val oneMinute = 1.minutes
    private val oneMinuteAgo = now - oneMinute
    private val oneMinuteFromNow = now + oneMinute
    private val twoMinutes = 2.minutes
    private val twoMinutesAgo = now - twoMinutes
    private val twentyMinutes = 20.minutes
    private val oneHour = 60.minutes
    private val oneHourAgo = now - oneHour
    private val oneHourFromNow = now + oneHour
    private val twoHours = 120.minutes
    private val twoHoursAgo = now - twoHours
    private val twoHoursFromNow = now + twoHours
    private val oneDay = 1.days
    private val oneDayAgo = now - oneDay
    private val oneDayFromNow = now + oneDay
    private val twoDays = 2.days
    private val twoDaysAgo = now - twoDays
    private val threeDays = 3.days
    private val fiveDays = 5.days
    private val oneWeek = 7.days
    private val oneWeekAgo = now - oneWeek
    private val oneWeekFromNow = now + oneWeek
    private val oneMonth = 31.days
    private val oneMonthAgo = now - oneMonth
    private val oneMonthFromNow = now + oneMonth
    private val twoMonths = 60.days
    private val twoMonthsAgo = now - twoMonths
    private val twoMonthsFromNow = now + twoMonths
    private val oneYear = 366.days
    private val oneYearAgo = now - oneYear
    private val oneYearFromNow = now + oneYear

    @Test
    fun ar_arabic() {
        HumanReadable.languageTag = "ar"
        assertThat(HumanReadable.duration(zeroSeconds)).isEqualTo("0 ثانية")
        assertThat(HumanReadable.duration(oneSecond)).isEqualTo("ثانية")
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("ثانيتان")
        assertThat(HumanReadable.duration(threeSeconds)).isEqualTo("3 ثوان")
        assertThat(HumanReadable.duration(elevenSeconds)).isEqualTo("11 ثانية")
        assertThat(HumanReadable.duration(threeDays)).isEqualTo("3 أيام")
        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("شهران")
        assertThat(HumanReadable.duration(oneYear)).isEqualTo("سنة")

        assertThat(HumanReadable.timeAgo(now, baseInstant = now)).isEqualTo("الآن")
        assertThat(HumanReadable.timeAgo(twoSecondsAgo, baseInstant = now)).isEqualTo("قبل ثانيتين")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("بعد دقيقة")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1,000,000.34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4.34")

        assertThat(HumanReadable.fileSize(2_000_000, decimals = 1)).isEqualTo("1.9 م.ب")

        assertThat(HumanReadable.abbreviation(5_100_000, decimals = 1)).isEqualTo("5.1M")

        assertThat(HumanReadable.distance(7234, unit = DistanceUnit.Meter)).isEqualTo("7.2 كم")
    }

    @Test
    fun cs_czech() {
        HumanReadable.languageTag = "cs"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 sekundy")
        assertThat(HumanReadable.duration(oneDay)).isEqualTo("1 den")
        assertThat(HumanReadable.duration(twoDays)).isEqualTo("2 dny")
        assertThat(HumanReadable.duration(fiveDays)).isEqualTo("5 dní")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")

        assertThat(HumanReadable.timeAgo(oneSecondFromNow, baseInstant = now)).isEqualTo("za 1 sekundu")
        assertThat(HumanReadable.timeAgo(twoSecondsAgo, baseInstant = now)).isEqualTo("před 2 sekundami")
        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("před 1 minutou")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("za 1 minutu")
        assertThat(HumanReadable.timeAgo(twoMinutesAgo, baseInstant = now)).isEqualTo("před 2 minutami")
        assertThat(HumanReadable.timeAgo(now - twentyMinutes, baseInstant = now)).isEqualTo("před 20 minutami")
        assertThat(HumanReadable.timeAgo(oneHourAgo, baseInstant = now)).isEqualTo("před 1 hodinou")
        assertThat(HumanReadable.timeAgo(oneHourFromNow, baseInstant = now)).isEqualTo("za 1 hodinu")
        assertThat(HumanReadable.timeAgo(oneDayAgo, baseInstant = now)).isEqualTo("před 1 dnem")
        assertThat(HumanReadable.timeAgo(twoDaysAgo, baseInstant = now)).isEqualTo("před 2 dny")
        assertThat(HumanReadable.timeAgo(now - fiveDays, baseInstant = now)).isEqualTo("před 5 dny")
        assertThat(HumanReadable.timeAgo(oneWeekAgo, baseInstant = now)).isEqualTo("před 1 týdnem")
        assertThat(HumanReadable.timeAgo(twoMonthsAgo, baseInstant = now)).isEqualTo("před 2 měsíci")
        assertThat(HumanReadable.timeAgo(oneYearAgo, baseInstant = now)).isEqualTo("před 1 rokem")
    }

    @Test
    fun de_german() {
        HumanReadable.languageTag = "de"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 Sekunden")
        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("2 Monate")

        assertThat(HumanReadable.timeAgo(twoMonthsAgo, baseInstant = now)).isEqualTo("vor 2 Monaten")
        assertThat(HumanReadable.timeAgo(twoMonthsFromNow, baseInstant = now)).isEqualTo("in 2 Monaten")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun el_greek() {
        HumanReadable.languageTag = "el"
        assertThat(HumanReadable.timeAgo(oneWeekAgo, baseInstant = now)).isEqualTo("1 εβδομάδα πριν")
        assertThat(HumanReadable.timeAgo(oneYearFromNow, baseInstant = now)).isEqualTo("σε 1 έτος")
        assertThat(HumanReadable.timeAgo(oneMonthAgo, baseInstant = now)).isEqualTo("1 μήνα πριν")
        assertThat(HumanReadable.timeAgo(oneMonthFromNow, baseInstant = now)).isEqualTo("σε 1 μήνα")

        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 δευτερόλεπτα")
        assertThat(HumanReadable.duration(oneMonth)).isEqualTo("1 μήνας")
        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("2 μήνες")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")

        assertThat(HumanReadable.fileSize(2_000_000, decimals = 1)).isEqualTo("1,9 MB")

        assertThat(HumanReadable.abbreviation(5_100_000, decimals = 1)).isEqualTo("5,1M")

        assertThat(HumanReadable.distance(7234, unit = DistanceUnit.Meter)).isEqualTo("7,2 km")
    }

    @Test
    fun en_english() {
        HumanReadable.languageTag = "en"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 seconds")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1,000,000.34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4.34")

        assertThat(HumanReadable.fileSize(2_000_000, decimals = 1)).isEqualTo("1.9 MB")

        assertThat(HumanReadable.abbreviation(5_100_000, decimals = 1)).isEqualTo("5.1M")

        assertThat(HumanReadable.distance(7234, unit = DistanceUnit.Meter)).isEqualTo("7.2 km")
    }

    @Test
    fun es_spanish() {
        HumanReadable.languageTag = "es"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 segundos")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun fi_finnish() {
        HumanReadable.languageTag = "fi"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 sekuntia")

        assertThat(HumanReadable.timeAgo(twoMinutesAgo, baseInstant = now)).isEqualTo("2 minuuttia sitten")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("1 minuutin kuluttua")
        assertThat(HumanReadable.timeAgo(twoHoursFromNow, baseInstant = now)).isEqualTo("2 tunnin kuluttua")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun fr_french() {
        HumanReadable.languageTag = "fr"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 secondes")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")

        assertThat(HumanReadable.fileSize(2_000_000, decimals = 1)).isEqualTo("1,9 Mo")
    }

    @Test
    fun id_indonesian() {
        HumanReadable.languageTag = "id"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 detik")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun it_italian() {
        HumanReadable.languageTag = "it"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 secondi")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun ja_japanese() {
        HumanReadable.languageTag = "ja"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 秒")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1,000,000.34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4.34")
    }

    @Test
    fun kk_kazakh() {
        HumanReadable.languageTag = "kk"
        assertThat(HumanReadable.timeAgo(now)).isEqualTo("қазір")
        assertThat(HumanReadable.timeAgo(twoSecondsAgo, baseInstant = now)).isEqualTo("2 секунд бұрын")
        assertThat(HumanReadable.timeAgo(twoSecondsFromNow, baseInstant = now)).isEqualTo("2 секундтан кейін")
        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 минут бұрын")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("1 минуттан кейін")
        assertThat(HumanReadable.timeAgo(oneHourAgo, baseInstant = now)).isEqualTo("1 сағат бұрын")
        assertThat(HumanReadable.timeAgo(oneHourFromNow, baseInstant = now)).isEqualTo("1 сағаттан кейін")
        assertThat(HumanReadable.timeAgo(oneDayAgo, baseInstant = now)).isEqualTo("1 күн бұрын")
        assertThat(HumanReadable.timeAgo(oneDayFromNow, baseInstant = now)).isEqualTo("1 күннен кейін")
        assertThat(HumanReadable.timeAgo(oneWeekAgo, baseInstant = now)).isEqualTo("1 апта бұрын")
        assertThat(HumanReadable.timeAgo(oneWeekFromNow, baseInstant = now)).isEqualTo("1 аптадан кейін")
        assertThat(HumanReadable.timeAgo(twoMonthsAgo, baseInstant = now)).isEqualTo("2 ай бұрын")
        assertThat(HumanReadable.timeAgo(twoMonthsFromNow, baseInstant = now)).isEqualTo("2 айдан кейін")
        assertThat(HumanReadable.timeAgo(oneYearAgo, baseInstant = now)).isEqualTo("1 жыл бұрын")
        assertThat(HumanReadable.timeAgo(oneYearFromNow, baseInstant = now)).isEqualTo("1 жылдан кейін")

        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 секунд")
        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 минут")
        assertThat(HumanReadable.duration(oneHour)).isEqualTo("1 сағат")
        assertThat(HumanReadable.duration(oneDay)).isEqualTo("1 күн")
        assertThat(HumanReadable.duration(oneWeek)).isEqualTo("1 апта")
        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("2 ай")
        assertThat(HumanReadable.duration(oneYear)).isEqualTo("1 жыл")
    }

    @Test
    fun ko_korean() {
        HumanReadable.languageTag = "ko"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2초")
        assertThat(HumanReadable.duration(twoMonths)).isEqualTo("2개월")

        assertThat(HumanReadable.timeAgo(oneHourAgo, baseInstant = now)).isEqualTo("1시간 전")
        assertThat(HumanReadable.timeAgo(twoHoursAgo, baseInstant = now)).isEqualTo("2시간 전")
        assertThat(HumanReadable.timeAgo(twoMonthsFromNow, baseInstant = now)).isEqualTo("2개월 후")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1,000,000.34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4.34")
    }

    @Test
    fun nl_dutch() {
        HumanReadable.languageTag = "nl"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 seconden")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")

        assertThat(HumanReadable.fileSize(2_000_000, decimals = 1)).isEqualTo("1,9 MB")

        assertThat(HumanReadable.abbreviation(5_100_000, decimals = 1)).isEqualTo("5,1M")

        assertThat(HumanReadable.distance(7234, unit = DistanceUnit.Meter)).isEqualTo("7,2 km")
    }

    @Test
    fun pl_polish() {
        HumanReadable.languageTag = "pl"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 sekundy")
        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 minuta")

        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 minutę temu")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("za 1 minutę")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun pt_portuguese() {
        HumanReadable.languageTag = "pt"
        assertThat(HumanReadable.duration(zeroSeconds)).isEqualTo("0 segundo")
        assertThat(HumanReadable.duration(oneSecond)).isEqualTo("1 segundo")
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 segundos")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun ru_russian() {
        HumanReadable.languageTag = "ru"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 секунды")
        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 минута")

        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 минуту назад")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("через 1 минуту")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun tr_turkish() {
        HumanReadable.languageTag = "tr"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 saniye")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun uk_ukrainian() {
        HumanReadable.languageTag = "uk"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 секунди")
        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 хвилина")
        assertThat(HumanReadable.duration(oneHour)).isEqualTo("1 година")

        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 хвилину тому")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("через 1 хвилину")
        assertThat(HumanReadable.timeAgo(oneHourAgo, baseInstant = now)).isEqualTo("1 годину тому")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1 000 000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun uz_uzbek() {
        HumanReadable.languageTag = "uz"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 soniya")
        assertThat(HumanReadable.duration(oneMinute)).isEqualTo("1 daqiqa")

        assertThat(HumanReadable.timeAgo(oneMinuteAgo, baseInstant = now)).isEqualTo("1 daqiqa oldin")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("1 daqiqadan keyin")
        assertThat(HumanReadable.timeAgo(twoHoursFromNow, baseInstant = now)).isEqualTo("2 soatdan keyin")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun vi_vietnamese() {
        HumanReadable.languageTag = "vi"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 giây")

        assertThat(HumanReadable.timeAgo(twoSecondsAgo, baseInstant = now)).isEqualTo("2 giây trước")
        assertThat(HumanReadable.timeAgo(oneMinuteFromNow, baseInstant = now)).isEqualTo("sau 1 phút")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1.000.000,34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4,34")
    }

    @Test
    fun zh_chinese() {
        HumanReadable.languageTag = "zh"
        assertThat(HumanReadable.duration(twoSeconds)).isEqualTo("2 秒")

        assertThat(HumanReadable.number(1_000_000.34, decimals = 2)).isEqualTo("1,000,000.34")
        assertThat(HumanReadable.number(-4.34, decimals = 2)).isEqualTo("-4.34")
    }
}