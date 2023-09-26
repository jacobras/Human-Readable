package nl.jacobras.humanreadable

import kotlin.test.Test
import kotlin.test.assertEquals

class HumanReadableFileSizeTests {

    @Test
    fun bytes() {
        assertEquals("9 B", HumanReadable.fileSize(9, decimals = 0))
        assertEquals("9 B", HumanReadable.fileSize(9, decimals = 1))
        assertEquals("9 B", HumanReadable.fileSize(9, decimals = 2))
    }

    @Test
    fun kilobytes() {
        assertEquals("300 kB", HumanReadable.fileSize(307_415, decimals = 0))
        assertEquals("300.2 kB", HumanReadable.fileSize(307_415, decimals = 1))
        assertEquals("300.21 kB", HumanReadable.fileSize(307_415, decimals = 2))
    }

    @Test
    fun megabytes() {
        assertEquals("5 MB", HumanReadable.fileSize(5_242_880, decimals = 0))
        assertEquals("5.0 MB", HumanReadable.fileSize(5_242_880, decimals = 1))
        assertEquals("5.00 MB", HumanReadable.fileSize(5_242_880, decimals = 2))
    }

    @Test
    fun gigabytes() {
        assertEquals("20 GB", HumanReadable.fileSize(20_411_000_000, decimals = 0))
        assertEquals("20.4 GB", HumanReadable.fileSize(20_411_000_000, decimals = 1))
        assertEquals("20.44 GB", HumanReadable.fileSize(20_411_000_000, decimals = 2))
    }
}