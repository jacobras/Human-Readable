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
        assertEquals("1 second", formatDuration(1.seconds))
        assertEquals("3 seconds", formatDuration(3.seconds))
    }

    @Test
    fun minutes() {
        assertEquals("1 minute", formatDuration(1.minutes))
        assertEquals("3 minutes", formatDuration(3.minutes))
    }

    @Test
    fun hours() {
        assertEquals("1 hour", formatDuration(1.hours))
        assertEquals("3 hours", formatDuration(3.hours))
        assertEquals("23 hours", formatDuration(23.hours))
    }

    @Test
    fun days() {
        assertEquals("1 day", formatDuration(1.days))
        assertEquals("3 days", formatDuration(3.days))
    }

    @Test
    fun weeks() {
        assertEquals("1 week", formatDuration(7.days))
        assertEquals("3 weeks", formatDuration(21.days))
    }

    @Test
    fun months() {
        assertEquals("1 month", formatDuration(30.days))
        assertEquals("3 months", formatDuration(90.days))
    }

    @Test
    fun years() {
        assertEquals("1 year", formatDuration(365.days))
        assertEquals("3 years", formatDuration(1095.days))
    }
}