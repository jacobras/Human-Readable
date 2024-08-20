package nl.jacobras.humanreadable

import Res
import kotlinx.datetime.Instant

/**
 * Returns the difference between [baseInstant] and [instant], in human-readable format.
 * Also supports instants in the future.
 *
 * @param instant The [Instant] to compare with [baseInstant].
 * @param baseInstant The base/starting [Instant], usually "now".
 */
internal fun formatTimeAgo(
    instant: Instant,
    baseInstant: Instant
): String {
    val diff = baseInstant - instant
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