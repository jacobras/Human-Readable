package nl.jacobras.humanreadable

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.skeptick.libres.LibresSettings
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

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