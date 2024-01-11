package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlin.test.Test

class HumanReadableFileSizeTests {

    init {
        LibresSettings.languageCode = "en"
    }

    @Test
    fun bytes() {
        assertThat(HumanReadable.fileSize(9, decimals = 0)).isEqualTo("9 B")
        assertThat(HumanReadable.fileSize(9, decimals = 1)).isEqualTo("9 B")
        assertThat(HumanReadable.fileSize(9, decimals = 2)).isEqualTo("9 B")
    }

    @Test
    fun kilobytes() {
        assertThat(HumanReadable.fileSize(307_415, decimals = 0)).isEqualTo("300 kB")
        assertThat(HumanReadable.fileSize(307_415, decimals = 1)).isEqualTo("300.2 kB")
        assertThat(HumanReadable.fileSize(307_415, decimals = 2)).isEqualTo("300.21 kB")
    }

    @Test
    fun megabytes() {
        assertThat(HumanReadable.fileSize(5_242_880, decimals = 0)).isEqualTo("5 MB")
        assertThat(HumanReadable.fileSize(5_242_880, decimals = 1)).isEqualTo("5.0 MB")
        assertThat(HumanReadable.fileSize(5_242_880, decimals = 2)).isEqualTo("5.00 MB")
    }

    @Test
    fun gigabytes() {
        assertThat(HumanReadable.fileSize(21_947_282_882, decimals = 0)).isEqualTo("20 GB")
        assertThat(HumanReadable.fileSize(21_947_282_882, decimals = 1)).isEqualTo("20.4 GB")
        assertThat(HumanReadable.fileSize(21_947_282_882, decimals = 2)).isEqualTo("20.44 GB")
    }

    @Test
    fun terabytes() {
        assertThat(HumanReadable.fileSize(61_253_792_783_400, decimals = 0)).isEqualTo("56 TB")
        assertThat(HumanReadable.fileSize(61_253_792_783_400, decimals = 1)).isEqualTo("55.7 TB")
        assertThat(HumanReadable.fileSize(61_253_792_783_400, decimals = 2)).isEqualTo("55.71 TB")
    }
}