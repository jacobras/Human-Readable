package nl.jacobras.humanreadable.time

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus
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

    @Test
    fun todayTomorrowYesterday() {
        val today = LocalDate.parse("2026-07-01")

        assertThat(
            HumanReadable.timeAgo(
                date = today.minus(1, DateTimeUnit.DAY),
                baseDate = today
            )
        ).isEqualTo("yesterday")
        assertThat(
            HumanReadable.timeAgo(
                date = today,
                baseDate = today
            )
        ).isEqualTo("today")
        assertThat(
            HumanReadable.timeAgo(
                date = today.plus(1, DateTimeUnit.DAY),
                baseDate = today
            )
        ).isEqualTo("tomorrow")
    }
}