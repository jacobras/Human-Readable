package nl.jacobras.humanreadable

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class HumanReadableTest {

    private val now: Instant
        get() = Clock.System.now()

    @Test
    fun formatFuture() {
        assertEquals("in the future", HumanReadable.timeAgo(now + 1.days))
    }

    @Test
    fun formatNow() {
        assertEquals("now", HumanReadable.timeAgo(now))
    }

    @Test
    fun formatSecondsAgo() {
        assertEquals("3 seconds ago", HumanReadable.timeAgo(now - 3.seconds))
    }

    @Test
    fun formatMinutesAgo() {
        assertEquals("3 minutes ago", HumanReadable.timeAgo(now - 3.minutes))
    }

    @Test
    fun formatHoursAgo() {
        assertEquals("3 hours ago", HumanReadable.timeAgo(now - 3.hours))
    }

    @Test
    fun formatDaysAgo() {
        assertEquals("3 days ago", HumanReadable.timeAgo(now - 3.days))
    }

    @Test
    fun formatWeeksAgo() {
        assertEquals("3 weeks ago", HumanReadable.timeAgo(now - 21.days))
    }

    @Test
    fun formatMonthsAgo() {
        assertEquals("3 months ago", HumanReadable.timeAgo(now - 90.days))
    }

    @Test
    fun formatYearsAgo() {
        assertEquals("3 years ago", HumanReadable.timeAgo(now - 1095.days))
    }
}