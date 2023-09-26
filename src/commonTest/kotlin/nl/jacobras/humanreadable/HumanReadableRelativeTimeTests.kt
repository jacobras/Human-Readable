package nl.jacobras.humanreadable

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.minutes

class HumanReadableRelativeTimeTests {

    private val now: Instant
        get() = Clock.System.now()

    @Test
    fun inFuture() {
        assertEquals("in 3 minutes", formatTimeAgo(now + 3.minutes))
    }

    @Test
    fun now() {
        assertEquals("now", formatTimeAgo(now))
    }

    @Test
    fun inPast() {
        assertEquals("3 days ago", formatTimeAgo(now - 3.days))
    }
}