package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.strings.strings
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Returns the difference between [baseInstant] and [instant], in human-readable format.
 * Also supports instants in the future.
 *
 * @param instant The [Instant] to compare with [baseInstant].
 * @param baseInstant The base/starting [Instant], usually "now".
 */
@OptIn(ExperimentalTime::class)
internal fun formatTimeAgo(
    instant: Instant,
    baseInstant: Instant
): String {
    val diff = baseInstant - instant
    val secondsAgo = diff.inWholeSeconds

    return when {
        secondsAgo < 0 -> strings.dateTime.timeInFuture(
            formatDuration(diff.absoluteValue, relativeTime = RelativeTime.Future)
        )
        secondsAgo <= 1 -> strings.dateTime.now
        else -> strings.dateTime.timeAgo(
            formatDuration(diff.absoluteValue, relativeTime = RelativeTime.Past)
        )
    }
}
