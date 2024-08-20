package nl.jacobras.humanreadable

import Res
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

/**
 * Returns the difference between now and [instant], in human-readable format.
 * Also supports instants in the future.
 */
internal fun formatTimeAgo(instant: Instant): String {
    val now = Clock.System.now()
    val diff = now - instant
    val secondsAgo = diff.inWholeSeconds

    return when {
        secondsAgo < 0 -> Res.string.time_in_future.format(
            formatDuration(diff.absoluteValue, relativeTime = RelativeTime.Future)
        )
        secondsAgo <= 1 -> Res.string.now
        else -> Res.string.time_ago.format(
            formatDuration(diff.absoluteValue, relativeTime = RelativeTime.Past)
        )
    }
}