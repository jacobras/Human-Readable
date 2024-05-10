package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlin.test.Test

class HumanReadableMetricPrefixTests {

    init {
        LibresSettings.languageCode = "en"
    }

    @Test
    fun bigMetricPrefixes() {
        assertThat(HumanReadable.metricPrefix(1.0)).isEqualTo("1")
        assertThat(HumanReadable.metricPrefix(100.0)).isEqualTo("100")
        assertThat(HumanReadable.metricPrefix(1_000.0)).isEqualTo("1k")
        assertThat(HumanReadable.metricPrefix(10_000.0)).isEqualTo("10k")
        assertThat(HumanReadable.metricPrefix(100_000.0)).isEqualTo("100k")
        assertThat(HumanReadable.metricPrefix(1_000_000.0)).isEqualTo("1M")
        assertThat(HumanReadable.metricPrefix(1_000_000_000.0)).isEqualTo("1G")
        assertThat(HumanReadable.metricPrefix(4_400_000_000_000.0)).isEqualTo("4T")
        assertThat(HumanReadable.metricPrefix(4_400_000_000_000.0, decimals = 1)).isEqualTo("4.4T")
        assertThat(HumanReadable.metricPrefix(8_000_000_000_000_000.0)).isEqualTo("8P")
        assertThat(HumanReadable.metricPrefix(9_000_000_000_000_000_000.0)).isEqualTo("9E")
    }

    @Test
    fun smallMetricPrefixes() {
        assertThat(HumanReadable.metricPrefix(0.1)).isEqualTo("1")
        assertThat(HumanReadable.metricPrefix(0.002)).isEqualTo("2m")
        assertThat(HumanReadable.metricPrefix(0.000_003)).isEqualTo("3μ")
        assertThat(HumanReadable.metricPrefix(0.000_000_003)).isEqualTo("3n")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_003)).isEqualTo("3p")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_000_003)).isEqualTo("3f")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_000_000_003)).isEqualTo("3a")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_000_000_000_003)).isEqualTo("3z")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_000_000_000_000_003)).isEqualTo("3y")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_000_000_000_000_000_003)).isEqualTo("3r")
        assertThat(HumanReadable.metricPrefix(0.000_000_000_000_000_000_000_000_000_003)).isEqualTo("3q")
    }
}