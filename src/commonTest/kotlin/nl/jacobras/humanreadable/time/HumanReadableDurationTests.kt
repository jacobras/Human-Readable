package nl.jacobras.humanreadable.time

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.localized.LocalisedTests
import kotlin.test.Test
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

/**
 * Main test for the specific configuration options related to duration formatting.
 *
 * All in English, see [LocalisedTests] for specific tests for the supported languages.
 */
class HumanReadableDurationTests {

    init {
        HumanReadable.languageTag = "en"
    }

    @Test
    fun defaultRounding() {
        assertThat(HumanReadable.duration(1.seconds)).isEqualTo("1 second")
        assertThat(HumanReadable.duration(3.seconds)).isEqualTo("3 seconds")
        assertThat(HumanReadable.duration(55.seconds)).isEqualTo("55 seconds")

        assertThat(HumanReadable.duration(1.minutes)).isEqualTo("1 minute")
        assertThat(HumanReadable.duration(3.minutes)).isEqualTo("3 minutes")
        assertThat(HumanReadable.duration(55.minutes)).isEqualTo("55 minutes")

        assertThat(HumanReadable.duration(1.hours)).isEqualTo("1 hour")
        assertThat(HumanReadable.duration(3.hours)).isEqualTo("3 hours")
        assertThat(HumanReadable.duration(23.hours)).isEqualTo("23 hours")

        assertThat(HumanReadable.duration(1.days)).isEqualTo("1 day")
        assertThat(HumanReadable.duration(3.days)).isEqualTo("3 days")

        assertThat(HumanReadable.duration(7.days)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(10.days)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(11.days)).isEqualTo("2 weeks")

        assertThat(HumanReadable.duration(21.days)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(29.days)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(30.days)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(31.days)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(90.days)).isEqualTo("3 months")

        assertThat(HumanReadable.duration(360.days)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(365.days)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(555.days)).isEqualTo("2 years")
        assertThat(HumanReadable.duration(1095.days)).isEqualTo("3 years")
    }

    @Test
    fun floorRounding() {
        assertThat(HumanReadable.duration(10.days, rounding = Rounding.Floor)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(11.days, rounding = Rounding.Floor)).isEqualTo("1 week")

        assertThat(HumanReadable.duration(21.days, rounding = Rounding.Floor)).isEqualTo("3 weeks")
        assertThat(HumanReadable.duration(29.days, rounding = Rounding.Floor)).isEqualTo("4 weeks")
        assertThat(HumanReadable.duration(30.days, rounding = Rounding.Floor)).isEqualTo("4 weeks")
        assertThat(HumanReadable.duration(31.days, rounding = Rounding.Floor)).isEqualTo("1 month")

        assertThat(HumanReadable.duration(360.days, rounding = Rounding.Floor)).isEqualTo("11 months")
        assertThat(HumanReadable.duration(365.days, rounding = Rounding.Floor)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(555.days, rounding = Rounding.Floor)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(1095.days, rounding = Rounding.Floor)).isEqualTo("3 years")
    }

    @Test
    fun upIfCloseRounding() {
        assertThat(HumanReadable.duration(1.seconds, rounding = Rounding.UpIfClose)).isEqualTo("1 second")
        assertThat(HumanReadable.duration(3.seconds, rounding = Rounding.UpIfClose)).isEqualTo("3 seconds")

        assertThat(HumanReadable.duration(55.seconds, rounding = Rounding.UpIfClose)).isEqualTo("1 minute")
        assertThat(HumanReadable.duration(1.minutes, rounding = Rounding.UpIfClose)).isEqualTo("1 minute")
        assertThat(HumanReadable.duration(3.minutes, rounding = Rounding.UpIfClose)).isEqualTo("3 minutes")

        assertThat(HumanReadable.duration(55.minutes, rounding = Rounding.UpIfClose)).isEqualTo("1 hour")
        assertThat(HumanReadable.duration(1.hours, rounding = Rounding.UpIfClose)).isEqualTo("1 hour")
        assertThat(HumanReadable.duration(3.hours, rounding = Rounding.UpIfClose)).isEqualTo("3 hours")

        assertThat(HumanReadable.duration(23.hours, rounding = Rounding.UpIfClose)).isEqualTo("1 day")
        assertThat(HumanReadable.duration(1.days, rounding = Rounding.UpIfClose)).isEqualTo("1 day")
        assertThat(HumanReadable.duration(3.days, rounding = Rounding.UpIfClose)).isEqualTo("3 days")

        assertThat(HumanReadable.duration(7.days, rounding = Rounding.UpIfClose)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(10.days, rounding = Rounding.UpIfClose)).isEqualTo("1 week")
        assertThat(HumanReadable.duration(11.days, rounding = Rounding.UpIfClose)).isEqualTo("2 weeks")

        assertThat(HumanReadable.duration(21.days, rounding = Rounding.UpIfClose)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(29.days, rounding = Rounding.UpIfClose)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(30.days, rounding = Rounding.UpIfClose)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(31.days, rounding = Rounding.UpIfClose)).isEqualTo("1 month")
        assertThat(HumanReadable.duration(90.days, rounding = Rounding.UpIfClose)).isEqualTo("3 months")

        assertThat(HumanReadable.duration(360.days, rounding = Rounding.UpIfClose)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(365.days, rounding = Rounding.UpIfClose)).isEqualTo("1 year")
        assertThat(HumanReadable.duration(555.days, rounding = Rounding.UpIfClose)).isEqualTo("2 years")
        assertThat(HumanReadable.duration(1095.days, rounding = Rounding.UpIfClose)).isEqualTo("3 years")
    }

    @Test
    fun limitedUnits() {
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Years))).isEqualTo("1 year")
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Months))).isEqualTo("13 months")
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Weeks))).isEqualTo("57 weeks")
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Days))).isEqualTo("400 days")
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Hours))).isEqualTo("9,600 hours")
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Minutes))).isEqualTo("576,000 minutes")
        assertThat(HumanReadable.duration(400.days, units = setOf(TimeUnit.Seconds))).isEqualTo("34,560,000 seconds")
    }
}