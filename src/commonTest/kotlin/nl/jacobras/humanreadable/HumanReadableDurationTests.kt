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
        assertEquals("1 second", HumanReadable.duration(1.seconds))
        assertEquals("3 seconds", HumanReadable.duration(3.seconds))
    }

    @Test
    fun minutes() {
        assertEquals("1 minute", HumanReadable.duration(1.minutes))
        assertEquals("3 minutes", HumanReadable.duration(3.minutes))
    }

    @Test
    fun hours() {
        assertEquals("1 hour", HumanReadable.duration(1.hours))
        assertEquals("3 hours", HumanReadable.duration(3.hours))
        assertEquals("23 hours", HumanReadable.duration(23.hours))
    }

    @Test
    fun days() {
        assertEquals("1 day", HumanReadable.duration(1.days))
        assertEquals("3 days", HumanReadable.duration(3.days))
    }

    @Test
    fun weeks() {
        assertEquals("1 week", HumanReadable.duration(7.days))
        assertEquals("3 weeks", HumanReadable.duration(21.days))
    }

    @Test
    fun months() {
        assertEquals("1 month", HumanReadable.duration(30.days))
        assertEquals("3 months", HumanReadable.duration(90.days))
    }

    @Test
    fun years() {
        assertEquals("1 year", HumanReadable.duration(365.days))
        assertEquals("3 years", HumanReadable.duration(1095.days))
    }
}