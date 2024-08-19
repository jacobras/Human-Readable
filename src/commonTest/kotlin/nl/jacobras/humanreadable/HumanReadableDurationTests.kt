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
}