package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlin.test.Test
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
class HumanReadableRelativeTimeTests {

    init {
        LibresSettings.languageCode = "en"
    }

    private val now: Instant
        get() = Clock.System.now()

    @Test
    fun inFuture() {
        assertThat(HumanReadable.timeAgo(now + 200.seconds)).isEqualTo("in 3 minutes")
    }

    @Test
    fun now() {
        assertThat(HumanReadable.timeAgo(now)).isEqualTo("now")
    }

    @Test
    fun inPast() {
        assertThat(HumanReadable.timeAgo(now - 3.days)).isEqualTo("3 days ago")
    }
}