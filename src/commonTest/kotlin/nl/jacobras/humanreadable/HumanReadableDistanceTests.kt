package nl.jacobras.humanreadable


import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class HumanReadableDistanceTests {
    @Test
    fun testLessThanAKm() {
        val distance = 956
        val expectedFormatted = "956 m"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.METERS)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun testMoreThanAKm() {
        val distance = 1534
        val expectedFormatted = "1.5 km"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.METERS)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun testLessThanAMile() {
        val distance = 5200
        val expectedFormatted = "5,200 ft"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.FEET)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun testMoreThanAMile() {
        val distance = 5350
        val expectedFormatted = "1.0 mi"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.FEET)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun testMoreThan1km() {
        val distance = 5400
        val expectedFormatted = "5.4 km"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.METERS)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun testMoreThan1mile() {
        val distance = 28512
        val expectedFormatted = "5.4 mi"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.FEET)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }
}