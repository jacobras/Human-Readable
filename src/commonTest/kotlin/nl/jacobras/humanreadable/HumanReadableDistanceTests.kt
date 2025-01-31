package nl.jacobras.humanreadable


import kotlin.test.Test
import kotlin.test.assertTrue

class HumanReadableDistanceTests {
    @Test
    fun testLessThanAKm() {
        val distance = 956
        val expectedFormatted = "956 m"
        val actualFormatted = HumanReadable.distance(meters = distance)
        assertTrue { actualFormatted == expectedFormatted }
    }

    @Test
    fun testMoreThanAKm() {
        val distance = 1534
        val expectedFormatted = "1.5 km"
        val actualFormatted = HumanReadable.distance(meters = distance)
        assertTrue {
            actualFormatted == expectedFormatted
        }
    }

    @Test
    fun testLessThanAMile() {
        val distance = 5200
        val expectedFormatted = "5200 ft"
        val actualFormatted = HumanReadable.distanceFt(feet = distance)
        assertTrue { actualFormatted == expectedFormatted }
    }

    @Test
    fun testMoreThanAMile() {
        val distance = 5350
        val expectedFormatted = "1.0 mi"
        val actualFormatted = HumanReadable.distanceFt(feet = distance)
        println("Actual formatted: $actualFormatted")
        assertTrue { actualFormatted == expectedFormatted }
    }
}