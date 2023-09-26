package nl.jacobras.humanreadable

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class HumanReadableDurationTests {

    @Test
    fun seconds() {
        assertEquals("3 seconds", formatDuration(3.seconds))
    }

    @Test
    fun minutes() {
        assertEquals("3 minutes", formatDuration(3.minutes))
    }

    @Test
    fun hours() {
        assertEquals("3 hours", formatDuration(3.hours))
    }

    @Test
    fun days() {
        assertEquals("3 days", formatDuration(3.days))
    }

    @Test
    fun weeks() {
        assertEquals("3 weeks", formatDuration(21.days))
    }

    @Test
    fun months() {
        assertEquals("3 months", formatDuration(90.days))
    }

    @Test
    fun years() {
        assertEquals("3 years", formatDuration(1095.days))
    }
}