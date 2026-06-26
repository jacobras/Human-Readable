package nl.jacobras.humanreadable.time

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.HumanReadable.duration
import nl.jacobras.humanreadable.localized.LocalisedTests
import nl.jacobras.humanreadable.time.Rounding.Floor
import nl.jacobras.humanreadable.time.Rounding.UpIfClose
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
        assertThat(duration(1.seconds)).isEqualTo("1 second")
        assertThat(duration(3.seconds)).isEqualTo("3 seconds")
        assertThat(duration(55.seconds)).isEqualTo("55 seconds")

        assertThat(duration(1.minutes)).isEqualTo("1 minute")
        assertThat(duration(3.minutes)).isEqualTo("3 minutes")
        assertThat(duration(55.minutes)).isEqualTo("55 minutes")

        assertThat(duration(1.hours)).isEqualTo("1 hour")
        assertThat(duration(3.hours)).isEqualTo("3 hours")
        assertThat(duration(23.hours)).isEqualTo("23 hours")

        assertThat(duration(1.days)).isEqualTo("1 day")
        assertThat(duration(3.days)).isEqualTo("3 days")

        assertThat(duration(7.days)).isEqualTo("1 week")
        assertThat(duration(10.days)).isEqualTo("1 week")
        assertThat(duration(11.days)).isEqualTo("2 weeks")

        assertThat(duration(21.days)).isEqualTo("1 month")
        assertThat(duration(29.days)).isEqualTo("1 month")
        assertThat(duration(30.days)).isEqualTo("1 month")
        assertThat(duration(31.days)).isEqualTo("1 month")
        assertThat(duration(90.days)).isEqualTo("3 months")

        assertThat(duration(360.days)).isEqualTo("1 year")
        assertThat(duration(365.days)).isEqualTo("1 year")
        assertThat(duration(555.days)).isEqualTo("2 years")
        assertThat(duration(1095.days)).isEqualTo("3 years")
    }

    @Test
    fun floorRounding() {
        assertThat(duration(10.days, rounding = Floor)).isEqualTo("1 week")
        assertThat(duration(11.days, rounding = Floor)).isEqualTo("1 week")

        assertThat(duration(21.days, rounding = Floor)).isEqualTo("3 weeks")
        assertThat(duration(29.days, rounding = Floor)).isEqualTo("4 weeks")
        assertThat(duration(30.days, rounding = Floor)).isEqualTo("4 weeks")
        assertThat(duration(31.days, rounding = Floor)).isEqualTo("1 month")

        assertThat(duration(360.days, rounding = Floor)).isEqualTo("11 months")
        assertThat(duration(365.days, rounding = Floor)).isEqualTo("1 year")
        assertThat(duration(555.days, rounding = Floor)).isEqualTo("1 year")
        assertThat(duration(1095.days, rounding = Floor)).isEqualTo("3 years")
    }

    @Test
    fun upIfCloseRounding() {
        assertThat(duration(1.seconds, rounding = UpIfClose)).isEqualTo("1 second")
        assertThat(duration(3.seconds, rounding = UpIfClose)).isEqualTo("3 seconds")

        assertThat(duration(55.seconds, rounding = UpIfClose)).isEqualTo("1 minute")
        assertThat(duration(1.minutes, rounding = UpIfClose)).isEqualTo("1 minute")
        assertThat(duration(3.minutes, rounding = UpIfClose)).isEqualTo("3 minutes")

        assertThat(duration(55.minutes, rounding = UpIfClose)).isEqualTo("1 hour")
        assertThat(duration(1.hours, rounding = UpIfClose)).isEqualTo("1 hour")
        assertThat(duration(3.hours, rounding = UpIfClose)).isEqualTo("3 hours")

        assertThat(duration(23.hours, rounding = UpIfClose)).isEqualTo("1 day")
        assertThat(duration(1.days, rounding = UpIfClose)).isEqualTo("1 day")
        assertThat(duration(3.days, rounding = UpIfClose)).isEqualTo("3 days")

        assertThat(duration(7.days, rounding = UpIfClose)).isEqualTo("1 week")
        assertThat(duration(10.days, rounding = UpIfClose)).isEqualTo("1 week")
        assertThat(duration(11.days, rounding = UpIfClose)).isEqualTo("1 week")

        assertThat(duration(21.days, rounding = UpIfClose)).isEqualTo("3 weeks")
        assertThat(duration(29.days, rounding = UpIfClose)).isEqualTo("4 weeks")
        assertThat(duration(30.days, rounding = UpIfClose)).isEqualTo("4 weeks")
        assertThat(duration(31.days, rounding = UpIfClose)).isEqualTo("1 month")
        assertThat(duration(90.days, rounding = UpIfClose)).isEqualTo("2 months")

        assertThat(duration(360.days, rounding = UpIfClose)).isEqualTo("11 months")
        assertThat(duration(365.days, rounding = UpIfClose)).isEqualTo("1 year")
        assertThat(duration(555.days, rounding = UpIfClose)).isEqualTo("1 year")
        assertThat(duration(1095.days, rounding = UpIfClose)).isEqualTo("3 years")
    }

    @Test
    fun limitedUnits() {
        assertThat(duration(400.days, units = setOf(TimeUnit.Years))).isEqualTo("1 year")
        assertThat(duration(400.days, units = setOf(TimeUnit.Months))).isEqualTo("13 months")
        assertThat(duration(400.days, units = setOf(TimeUnit.Weeks))).isEqualTo("57 weeks")
        assertThat(duration(400.days, units = setOf(TimeUnit.Days))).isEqualTo("400 days")
        assertThat(duration(400.days, units = setOf(TimeUnit.Hours))).isEqualTo("9,600 hours")
        assertThat(duration(400.days, units = setOf(TimeUnit.Minutes))).isEqualTo("576,000 minutes")
        assertThat(duration(400.days, units = setOf(TimeUnit.Seconds))).isEqualTo("34,560,000 seconds")
    }
}