package nl.jacobras.humanreadable.time

import kotlinx.datetime.TimeZone
import nl.jacobras.humanreadable.HumanReadable.strings
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Returns the difference between [baseInstant] and [instant], in human-readable format.
 * Also supports instants in the future.
 *
 * @param instant The [Instant] to compare with [baseInstant].
 * @param baseInstant The base/starting [Instant], usually "now".
 * @param formatStyle The [FormatStyle] to use.
 * @param timeZone If set, today/tomorrow/yesterday will be used.
 * @param parts Configures the formatting of multiple parts (defaults to 1 part).
 * @param units The [TimeUnit]s to limit to during formatting.
 * @param rounding The [Rounding] strategy to use.
 */
@OptIn(ExperimentalTime::class)
internal fun formatTimeAgo(
    instant: Instant,
    baseInstant: Instant,
    formatStyle: FormatStyle,
    timeZone: TimeZone?,
    parts: Parts,
    units: Set<TimeUnit>,
    rounding: Rounding
): String {
    val diff = baseInstant - instant
    val secondsAgo = diff.inWholeSeconds

    return when {
        secondsAgo < 0 -> strings.dateTime.timeInFuture(
            formatDuration(
                duration = diff.absoluteValue,
                relativeTime = RelativeTime.Future,
                formatStyle = formatStyle,
                parts = parts,
                units = units,
                rounding = rounding
            )
        )
        secondsAgo <= 1 -> strings.dateTime.now
        else -> strings.dateTime.timeAgo(
            formatDuration(
                duration = diff.absoluteValue,
                relativeTime = RelativeTime.Past,
                formatStyle = formatStyle,
                parts = parts,
                units = units,
                rounding = rounding
            )
        )
    }
}