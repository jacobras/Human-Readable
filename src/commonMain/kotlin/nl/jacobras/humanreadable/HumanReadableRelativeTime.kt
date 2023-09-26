package nl.jacobras.humanreadable

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
        secondsAgo < 0 -> {
            "in ${formatDuration(diff.absoluteValue)}"
        }
        secondsAgo <= 1 -> {
            "now"
        }
        else -> "${formatDuration(diff)} ago"
    }
}