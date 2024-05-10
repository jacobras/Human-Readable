package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlin.test.Test

class HumanReadableAbbreviationTests {

    init {
        LibresSettings.languageCode = "en"
    }

    @Test
    fun abbreviations() {
        assertThat(HumanReadable.abbreviation(1)).isEqualTo("1")
        assertThat(HumanReadable.abbreviation(100)).isEqualTo("100")
        assertThat(HumanReadable.abbreviation(1_000)).isEqualTo("1K")
        assertThat(HumanReadable.abbreviation(10_000)).isEqualTo("10K")
        assertThat(HumanReadable.abbreviation(100_000)).isEqualTo("100K")
        assertThat(HumanReadable.abbreviation(1_000_000)).isEqualTo("1M")
        assertThat(HumanReadable.abbreviation(1_000_000_000)).isEqualTo("1B")
        assertThat(HumanReadable.abbreviation(4_400_000_000_000)).isEqualTo("4T")
        assertThat(HumanReadable.abbreviation(4_400_000_000_000, decimals = 1)).isEqualTo("4.4T")
    }
}