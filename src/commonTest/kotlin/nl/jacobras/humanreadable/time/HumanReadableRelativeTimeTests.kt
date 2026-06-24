package nl.jacobras.humanreadable.time

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.localized.LocalisedTests
import kotlin.test.Test
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Main test for the specific configuration options related to relative time formatting.
 *
 * All in English, see [LocalisedTests] for specific tests for the supported languages.
 */
@OptIn(ExperimentalTime::class)
class HumanReadableRelativeTimeTests {

    init {
        HumanReadable.languageTag = "en"
    }

    private val now: Instant
        get() = Clock.System.now()

    @Test
    fun inFuture() {
        assertThat(HumanReadable.timeAgo(now + 200.seconds, baseInstant = now)).isEqualTo("in 3 minutes")
    }

    @Test
    fun now() {
        assertThat(HumanReadable.timeAgo(now, baseInstant = now)).isEqualTo("now")
    }

    @Test
    fun inPast() {
        assertThat(HumanReadable.timeAgo(now - 3.days, baseInstant = now)).isEqualTo("3 days ago")
    }
}