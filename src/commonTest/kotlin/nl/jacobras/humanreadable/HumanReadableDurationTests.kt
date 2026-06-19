package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlin.test.Test
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class HumanReadableDurationTests {

    init {
        LibresSettings.languageCode = "en"
    }

    @Test
    fun seconds() {
        assertThat(HumanReadable.duration(1.seconds)).isEqualTo("1 second")
        assertThat(HumanReadable.duration(3.seconds)).isEqualTo("3 seconds")
    }

    @Test
    fun minutes() {
        assertThat(HumanReadable.duration(1.minutes)).isEqualTo("1 minute")
        assertThat(HumanReadable.duration(3.minutes)).isEqualTo("3 minutes")
    }

    @Test
    fun hours() {
        assertThat(HumanReadable.duration(1.hours)).isEqualTo("1 hour")
        assertThat(HumanReadable.duration(3.hours)).isEqualTo("3 hours")
        assertThat(HumanReadable.duration(23.hours)).isEqualTo("23 hours")
    }

    @Test
    fun days() {
        assertThat(HumanReadable.duration(1.days)).isEqualTo("1 day")
        assertThat(HumanReadable.duration(3.days)).isEqualTo("3 days")
    }

    @Test
    fun weeks() {
        assertThat(HumanReadable.duration(7.days)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(10.days)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(11.days)).isEqualTo("2 weeks")
        assertThat(HumanReadable.duration(21.days)).isEqualTo("3 weeks")
    }

    @Test
    fun months() {
        assertThat(HumanReadable.duration(30.days)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(90.days)).isEqualTo("3 months")
        assertThat(HumanReadable.duration(364.days)).isEqualTo("12 months")
    }

    @Test
    fun years() {
        assertThat(HumanReadable.duration(365.days)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(1095.days)).isEqualTo("3 years")
    }

    @Test
    fun fixedUnitSeconds() {
        assertThat(HumanReadable.duration(90.minutes, DurationUnit.Seconds)).isEqualTo("5400 seconds")
        assertThat(HumanReadable.duration(1.hours, DurationUnit.Seconds)).isEqualTo("3600 seconds")
    }

    @Test
    fun fixedUnitMinutes() {
        assertThat(HumanReadable.duration(2.hours, DurationUnit.Minutes)).isEqualTo("120 minutes")
    }

    @Test
    fun fixedUnitHours() {
        assertThat(HumanReadable.duration(3.days, DurationUnit.Hours)).isEqualTo("72 hours")
    }

    @Test
    fun fixedUnitDays() {
        assertThat(HumanReadable.duration(32.days, DurationUnit.Days)).isEqualTo("32 days")
        assertThat(HumanReadable.duration(1.days, DurationUnit.Days)).isEqualTo("1 day")
    }

    @Test
    fun fixedUnitWeeks() {
        assertThat(HumanReadable.duration(32.days, DurationUnit.Weeks)).isEqualTo("4 weeks")
        assertThat(HumanReadable.duration(7.days, DurationUnit.Weeks)).isEqualTo("1 week")
    }

    @Test
    fun fixedUnitFallsBackToSmallerUnitWhenNonZeroDurationWouldBeZero() {
        assertThat(HumanReadable.duration(6.days, DurationUnit.Weeks)).isEqualTo("6 days")
        assertThat(HumanReadable.duration(23.hours, DurationUnit.Days)).isEqualTo("23 hours")
    }

    @Test
    fun fixedUnitMonths() {
        assertThat(HumanReadable.duration(90.days, DurationUnit.Months)).isEqualTo("3 months")
    }

    @Test
    fun fixedUnitYears() {
        assertThat(HumanReadable.duration(730.days, DurationUnit.Years)).isEqualTo("2 years")
    }

    @Test
    fun fixedUnitLargeCountsDoNotOverflow() {
        assertThat(HumanReadable.duration(36_500.days, DurationUnit.Seconds)).isEqualTo("3153600000 seconds")
        assertThat(HumanReadable.duration(2_000_000.days, DurationUnit.Minutes)).isEqualTo("2880000000 minutes")
        assertThat(HumanReadable.duration(100_000_000.days, DurationUnit.Hours)).isEqualTo("2400000000 hours")
    }

    @Test
    fun fixedUnitLargeLocalizedCountsUsePluralFormFromDisplayValue() {
        LibresSettings.languageCode = "ru"

        assertThat(HumanReadable.duration(2_147_483_651.seconds, DurationUnit.Seconds))
            .isEqualTo("2147483651 секунда")

        LibresSettings.languageCode = "en"
    }

    @Test
    fun fixedUnitArabicSingularAndDualOmitNumeral() {
        LibresSettings.languageCode = "ar"

        assertThat(HumanReadable.duration(1.days, DurationUnit.Days)).isEqualTo("يوم")
        assertThat(HumanReadable.duration(2.days, DurationUnit.Days)).isEqualTo("يومان")

        LibresSettings.languageCode = "en"
    }
}
