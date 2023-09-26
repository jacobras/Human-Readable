package nl.jacobras.humanreadable

import kotlin.test.Test
import kotlin.test.assertEquals

class HumanReadableFileSizeTests {

    @Test
    fun bytes() {
        assertEquals("9 B", formatFileSize(9, decimals = 0))
        assertEquals("9 B", formatFileSize(9, decimals = 1))
        assertEquals("9 B", formatFileSize(9, decimals = 2))
    }

    @Test
    fun kilobytes() {
        assertEquals("300 kB", formatFileSize(307_415, decimals = 0))
        assertEquals("300.2 kB", formatFileSize(307_415, decimals = 1))
        assertEquals("300.21 kB", formatFileSize(307_415, decimals = 2))
    }

    @Test
    fun megabytes() {
        assertEquals("5 MB", formatFileSize(5_242_880, decimals = 0))
        assertEquals("5.0 MB", formatFileSize(5_242_880, decimals = 1))
        assertEquals("5.00 MB", formatFileSize(5_242_880, decimals = 2))
    }

    @Test
    fun gigabytes() {
        assertEquals("20 GB", formatFileSize(21_947_282_882, decimals = 0))
        assertEquals("20.4 GB", formatFileSize(21_947_282_882, decimals = 1))
        assertEquals("20.44 GB", formatFileSize(21_947_282_882, decimals = 2))
    }

    @Test
    fun terabytes() {
        assertEquals("56 TB", formatFileSize(61_253_792_783_400, decimals = 0))
        assertEquals("55.7 TB", formatFileSize(61_253_792_783_400, decimals = 1))
        assertEquals("55.71 TB", formatFileSize(61_253_792_783_400, decimals = 2))
    }
}