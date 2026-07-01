package nl.jacobras.humanreadable.time

import assertk.assertThat
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.HumanReadable.duration
import nl.jacobras.humanreadable.localized.LocalisedTests
import nl.jacobras.humanreadable.time.Rounding.Floor
import nl.jacobras.humanreadable.time.Rounding.HalfUp
import nl.jacobras.humanreadable.time.Rounding.UpIfClose
import kotlin.test.Test
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import nl.jacobras.humanreadable.time.FormatStyle.Long as FormatLong
import nl.jacobras.humanreadable.time.FormatStyle.LongApproximate as FormatLongApproximate
import nl.jacobras.humanreadable.time.FormatStyle.Narrow as FormatNarrow
import nl.jacobras.humanreadable.time.FormatStyle.Short as FormatShort

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
    fun halfUpRounding() {
        assertThat(duration(1.seconds, rounding = HalfUp)).isEqualTo("1 second")
        assertThat(duration(3.seconds, rounding = HalfUp)).isEqualTo("3 seconds")
        assertThat(duration(55.seconds, rounding = HalfUp)).isEqualTo("55 seconds")

        assertThat(duration(1.minutes, rounding = HalfUp)).isEqualTo("1 minute")
        assertThat(duration(1.minutes + 55.seconds, rounding = HalfUp)).isEqualTo("2 minutes")
        assertThat(duration(3.minutes, rounding = HalfUp)).isEqualTo("3 minutes")
        assertThat(duration(55.minutes, rounding = HalfUp)).isEqualTo("55 minutes")

        assertThat(duration(1.hours, rounding = HalfUp)).isEqualTo("1 hour")
        assertThat(duration(3.hours, rounding = HalfUp)).isEqualTo("3 hours")
        assertThat(duration(23.hours, rounding = HalfUp)).isEqualTo("23 hours")

        assertThat(duration(1.days, rounding = HalfUp)).isEqualTo("1 day")
        assertThat(duration(3.days, rounding = HalfUp)).isEqualTo("3 days")

        assertThat(duration(7.days, rounding = HalfUp)).isEqualTo("1 week")
        assertThat(duration(10.days, rounding = HalfUp)).isEqualTo("1 week")
        assertThat(duration(11.days, rounding = HalfUp)).isEqualTo("2 weeks")
        assertThat(duration(12.days, rounding = HalfUp)).isEqualTo("2 weeks")

        assertThat(duration(21.days, rounding = HalfUp)).isEqualTo("3 weeks")
        assertThat(duration(29.days, rounding = HalfUp)).isEqualTo("4 weeks")
        assertThat(duration(30.days, rounding = HalfUp)).isEqualTo("4 weeks")
        assertThat(duration(31.days, rounding = HalfUp)).isEqualTo("1 month")
        assertThat(duration(46.days, rounding = HalfUp)).isEqualTo("2 months")
        assertThat(duration(90.days, rounding = HalfUp)).isEqualTo("3 months")

        assertThat(duration(360.days, rounding = HalfUp)).isEqualTo("12 months")
        assertThat(duration(365.days, rounding = HalfUp)).isEqualTo("1 year")
        assertThat(duration(555.days, rounding = HalfUp)).isEqualTo("2 years")
        assertThat(duration(1095.days, rounding = HalfUp)).isEqualTo("3 years")
    }

    @Test
    fun floorRounding() {
        assertThat(duration(10.days, rounding = Floor)).isEqualTo("1 week")
        assertThat(duration(11.days, rounding = Floor)).isEqualTo("1 week")
        assertThat(duration(12.days, rounding = Floor)).isEqualTo("1 week")

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
        assertThat(duration(12.days, rounding = UpIfClose)).isEqualTo("1 week")

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
        assertThat(duration(400.days, units = emptySet())).isEmpty()
        assertThat(duration(1.days, units = setOf(TimeUnit.Months))).isEqualTo("0 months")
    }

    @Test
    fun multipleParts() {
        assertThat(
            duration(70.seconds, parts = Parts(max = 2))
        ).isEqualTo("1 minute, 10 seconds")
        assertThat(
            duration(90.minutes + 10.seconds, parts = Parts(max = 3, subpartCutOffs = emptyMap()))
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

        // Edge cases
        assertThat(
            duration(59.minutes + 55.seconds, rounding = UpIfClose, parts = Parts(max = 2))
        ).isEqualTo("1 hour")
        assertThat(
            duration(23.hours + 55.minutes, rounding = UpIfClose, parts = Parts(max = 2))
        ).isEqualTo("1 day")
        assertThat(
            duration(6.days + 23.hours, rounding = UpIfClose, parts = Parts(max = 2))
        ).isEqualTo("7 days")
    }

    @Test
    fun smallestDuration() {
        assertThat(
            duration(44.seconds, parts = Parts(smallestDuration = 45.seconds), formatStyle = FormatLong)
        ).isEqualTo("less than 45 seconds")
        assertThat(
            duration(10.minutes, parts = Parts(smallestDuration = 15.minutes), formatStyle = FormatLong)
        ).isEqualTo("less than 15 minutes")

        assertThat(
            duration(44.seconds, parts = Parts(smallestDuration = 45.seconds), formatStyle = FormatLongApproximate)
        ).isEqualTo("less than 45 seconds")
        assertThat(
            duration(10.minutes, parts = Parts(smallestDuration = 15.minutes), formatStyle = FormatLongApproximate)
        ).isEqualTo("less than 15 minutes")

        assertThat(
            duration(44.seconds, parts = Parts(smallestDuration = 45.seconds), formatStyle = FormatNarrow)
        ).isEqualTo("<45s")
        assertThat(
            duration(10.minutes, parts = Parts(smallestDuration = 15.minutes), formatStyle = FormatNarrow)
        ).isEqualTo("<15m")

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
        ).isEqualTo("19 hours")
        assertThat(
            duration(20.hours + 4.minutes, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Hours to 2)))
        ).isEqualTo("20 hours")

        assertThat(
            duration(1.days + 5.hours, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Days to 2)))
        ).isEqualTo("1 day, 5 hours")
        assertThat(
            duration(2.days + 5.hours, parts = Parts(max = 2, subpartCutOffs = mapOf(TimeUnit.Days to 2)))
        ).isEqualTo("2 days")
    }

    @Test
    fun formatStyle() {
        assertThat(
            duration(1.hours + 50.minutes, formatStyle = FormatLong, parts = Parts(max = 2))
        ).isEqualTo("1 hour, 50 minutes")
        assertThat(
            duration(1.hours + 50.minutes, formatStyle = FormatShort, parts = Parts(max = 2))
        ).isEqualTo("1 hr, 50 min")
        assertThat(
            duration(1.hours + 50.minutes, formatStyle = FormatNarrow, parts = Parts(max = 2))
        ).isEqualTo("1h 50m")

        assertThat(duration(1.hours, formatStyle = FormatLong)).isEqualTo("1 hour")
        assertThat(duration(1.hours, formatStyle = FormatShort)).isEqualTo("1 hr")
        assertThat(duration(1.hours, formatStyle = FormatNarrow)).isEqualTo("1h")
        assertThat(duration(14.days, formatStyle = FormatLong)).isEqualTo("2 weeks")
        assertThat(duration(14.days, formatStyle = FormatShort)).isEqualTo("2 wks")
        assertThat(duration(14.days, formatStyle = FormatNarrow)).isEqualTo("2w")
        assertThat(duration(180.days, formatStyle = FormatLong)).isEqualTo("6 months")
        assertThat(duration(180.days, formatStyle = FormatShort)).isEqualTo("6 mths")
        assertThat(duration(180.days, formatStyle = FormatNarrow)).isEqualTo("6m")
    }

    @Test
    fun formatStyleApproximation() {
        assertThat(duration(1.hours, formatStyle = FormatLongApproximate)).isEqualTo("1 hour")
        assertThat(duration(1.hours + 1.minutes, formatStyle = FormatLongApproximate)).isEqualTo("about 1 hour")
        assertThat(
            duration(1.hours + 1.minutes, formatStyle = FormatLongApproximate, parts = Parts(smallestDuration = 1.days))
        ).isEqualTo("less than 1 day")
    }
}