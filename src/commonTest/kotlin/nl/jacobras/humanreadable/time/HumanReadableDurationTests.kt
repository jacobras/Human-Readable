package nl.jacobras.humanreadable.time

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.HumanReadable.duration
import nl.jacobras.humanreadable.localized.LocalisedTests
import nl.jacobras.humanreadable.time.FormatStyle.*
import nl.jacobras.humanreadable.time.Rounding.*
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
        assertThat(duration(46.days)).isEqualTo("2 months")
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
        assertThat(duration(46.days, rounding = Floor)).isEqualTo("1 month")

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

    @Test
    fun multipleParts() {
        assertThat(
            duration(70.seconds, parts = Parts(max = 2))
        ).isEqualTo("1 minute, 10 seconds")
        assertThat(
            duration(90.minutes + 10.seconds, parts = Parts(max = 3))
        ).isEqualTo("1 hour, 30 minutes, 10 seconds")
        assertThat(
            duration(3.seconds, parts = Parts(max = 2))
        ).isEqualTo("3 seconds")
        assertThat(
            duration(1.hours + 10.seconds, parts = Parts(max = 2))
        ).isEqualTo("1 hour, 10 seconds")
        assertThat(
            duration(1.minutes + 55.seconds, rounding = HalfUp, parts = Parts(max = 2))
        ).isEqualTo("1 minute, 55 seconds")
        assertThat(
            duration(1.minutes + 55.seconds, rounding = UpIfClose, parts = Parts(max = 2))
        ).isEqualTo("2 minutes")
    }

    @Test
    fun smallestDuration() {
        assertThat(
            duration(44.seconds, parts = Parts(smallestDuration = 45.seconds), formatStyle = Regular)
        ).isEqualTo("less than 45 seconds")
        assertThat(
            duration(44.seconds, parts = Parts(smallestDuration = 45.seconds), formatStyle = WithApproximation)
        ).isEqualTo("less than 45 seconds")
        assertThat(
            duration(44.seconds, parts = Parts(smallestDuration = 45.seconds), formatStyle = Abbreviated)
        ).isEqualTo("<45s")
        assertThat(duration(45.seconds, parts = Parts(smallestDuration = 45.seconds))).isEqualTo("45 seconds")
    }

    @Test
    fun subpartsCutOffs() {
        assertThat(
            duration(1.minutes + 4.seconds, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Minutes to 2)))
        ).isEqualTo("1 minute, 4 seconds")
        assertThat(
            duration(2.minutes + 4.seconds, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Minutes to 2)))
        ).isEqualTo("2 minutes")

        assertThat(
            duration(19.hours + 4.minutes, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Hours to 2)))
        ).isEqualTo("1 minute, 4 seconds")
        assertThat(
            duration(20.hours + 4.minutes, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Hours to 2)))
        ).isEqualTo("2 minutes")

        assertThat(
            duration(1.days + 5.hours, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Days to 2)))
        ).isEqualTo("1 day, 5 hours")
        assertThat(
            duration(2.days + 5.hours, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Days to 2)))
        ).isEqualTo("2 days")
    }

    @Test
    fun formatStyle() {
        assertThat(duration(1.hours, formatStyle = WithApproximation)).isEqualTo("1 hour")
        assertThat(duration(1.hours + 1.minutes, formatStyle = WithApproximation)).isEqualTo("about 1 hour")

        assertThat(duration(1.hours, formatStyle = Regular)).isEqualTo("1 hour")
        assertThat(duration(1.hours, formatStyle = Abbreviated)).isEqualTo("1h")
        assertThat(duration(14.days, formatStyle = Regular)).isEqualTo("2 weeks")
        assertThat(duration(14.days, formatStyle = Abbreviated)).isEqualTo("2w")
        assertThat(duration(180.days, formatStyle = Regular)).isEqualTo("5 months")
        assertThat(duration(180.days, formatStyle = Abbreviated)).isEqualTo("5mo")
    }
}