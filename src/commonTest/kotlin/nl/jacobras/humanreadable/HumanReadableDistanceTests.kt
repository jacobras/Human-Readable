package nl.jacobras.humanreadable


import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class HumanReadableDistanceTests {

    @Test
    fun decimals() {
        // Meters and feet are always formatted to 0 decimals.
        assertThat(
            HumanReadable.distance(value = 123, unit = DistanceUnit.Meters, decimals = 3)
        ).isEqualTo("123 m")
        assertThat(
            HumanReadable.distance(value = 123, unit = DistanceUnit.Feet, decimals = 3)
        ).isEqualTo("123 ft")

        // Larger units are formatted according to the passed in number of decimals.
        assertThat(
            HumanReadable.distance(value = 56789, unit = DistanceUnit.Meters, decimals = 2)
        ).isEqualTo("56.79 km")
        assertThat(
            HumanReadable.distance(value = 56789, unit = DistanceUnit.Feet, decimals = 2)
        ).isEqualTo("10.76 mi")
    }

    @Test
    fun lessThan1Km() {
        val actualFormatted = HumanReadable.distance(value = 956, unit = DistanceUnit.Meters)
        assertThat(actualFormatted).isEqualTo("956 m")
    }

    @Test
    fun moreThan1Km() {
        val distance = 1534
        val expectedFormatted = "1.5 km"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.Meters)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun lessThan1Mile() {
        val distance = 5200
        val expectedFormatted = "5,200 ft"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.Feet)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun moreThan1Mile() {
        val distance = 5350
        val expectedFormatted = "1.0 mi"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.Feet)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun moreThan1km() {
        val distance = 5400
        val expectedFormatted = "5.4 km"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.Meters)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }

    @Test
    fun moreThan1mile() {
        val distance = 28512
        val expectedFormatted = "5.4 mi"
        val actualFormatted = HumanReadable.distance(value = distance, unit = DistanceUnit.Feet)
        println("Expected: $expectedFormatted, actual: $actualFormatted")
        assertThat(actualFormatted).isEqualTo(expectedFormatted)
    }
}