package nl.jacobras.humanreadable.time

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import nl.jacobras.humanreadable.HumanReadable.strings
import kotlin.math.absoluteValue
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Returns the difference between [baseInstant] and [instant], in human-readable format.
 * Also supports instants in the future or past.
 *
 * @param instant The [Instant] to compare with [baseInstant].
 * @param baseInstant The base/starting [Instant], usually "now".
 * @param formatStyle The [FormatStyle] to use.
 * @param parts Configures the formatting of multiple parts (defaults to 1 part).
 * @param units The [TimeUnit]s to limit to during formatting.
 * @param rounding The [Rounding] strategy to use.
 */
@OptIn(ExperimentalTime::class)
internal fun formatTimeAgo(
    instant: Instant,
    baseInstant: Instant,
    formatStyle: FormatStyle,
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
                format = formatStyle,
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
                format = formatStyle,
                parts = parts,
                units = units,
                rounding = rounding
            )
        )
    }
}

/**
 * Returns the difference between [date] and [baseDate], in human-readable format.
 * Also supports dates in the future or past.
 *
 * Will return "today", "tomorrow" or "yesterday" if the date is today, tomorrow, or yesterday.
 *
 * @param date The [LocalDate] to compare with [baseDate].
 * @param baseDate The base/starting [LocalDate], usually "today".
 * @param formatStyle The [FormatStyle] to use.
 * @param parts Configures the formatting of multiple parts (defaults to 1 part).
 * @param units The [TimeUnit]s to limit to during formatting.
 * @param rounding The [Rounding] strategy to use.
 */
internal fun formatTimeAgo(
    date: LocalDate,
    baseDate: LocalDate,
    formatStyle: FormatStyle,
    parts: Parts,
    units: Set<TimeUnit>,
    rounding: Rounding
): String {
    when (date) {
        baseDate.minus(1, DateTimeUnit.DAY) -> return strings.dateTime.yesterday
        baseDate -> return strings.dateTime.today
        baseDate.plus(1, DateTimeUnit.DAY) -> return strings.dateTime.tomorrow
    }
    val secondsAgo = (baseDate - date).seconds

    return when {
        secondsAgo < 0 -> strings.dateTime.timeInFuture(
            formatDuration(
                duration = secondsAgo.absoluteValue.seconds,
                relativeTime = RelativeTime.Future,
                format = formatStyle,
                parts = parts,
                units = units,
                rounding = rounding
            )
        )
        secondsAgo <= 1 -> strings.dateTime.now
        else -> strings.dateTime.timeAgo(
            formatDuration(
                duration = secondsAgo.absoluteValue.seconds,
                relativeTime = RelativeTime.Past,
                format = formatStyle,
                parts = parts,
                units = units,
                rounding = rounding
            )
        )
    }
}