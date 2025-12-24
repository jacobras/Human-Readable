package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlin.test.Test

class HumanReadableNumberEdgeCaseTests {
    init {
        LibresSettings.languageCode = "en"
    }

    @Test
    fun floatingPointWithoutWholeNumber() {
        assertThat(HumanReadable.number(0.04, decimals = 2)).isEqualTo("0.04")
        assertThat(HumanReadable.number(00000.00004, decimals = 3)).isEqualTo("0.000")
    }

    @Test
    fun negativeNumber() {
        assertThat(HumanReadable.number(-123456)).isEqualTo("-123,456")
        assertThat(HumanReadable.number(-123)).isEqualTo("-123")
    }
}