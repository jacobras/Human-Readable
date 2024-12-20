@file:Suppress("unused")

package nl.jacobras.humanreadable

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration

/**
 * A collection of data formatting utilities.
 */
object HumanReadable {

    init {
        extendLibresPlurals()
    }

    /**
     * Returns the difference between now and [instant], in human-readable format. Also supports
     * instants in the future. For example: an instant that's 5 hours ago will return "5 hours ago".
     *
     * @param instant The [Instant] to format.
     * @return a formatted string
     */
    fun timeAgo(
        instant: Instant,
        baseInstant: Instant = Clock.System.now()
    ): String {
        return safelyTranslate { formatTimeAgo(instant, baseInstant) }
    }

    /**
     * Returns the given [duration] in human-readable format.
     * For example: a duration of 3 seconds returns "3 seconds".
     *
     * @param duration The [Duration] to format.
     * @return a formatted string
     */
    fun duration(duration: Duration): String {
        return safelyTranslate { formatDuration(duration, RelativeTime.Present) }
    }

    /**
     * Returns the given [bytes] size in human-readable format. For example:
     * a size of 3_500_000 bytes returns "3.5 MB". Assumes base 1024.
     *
     * For example, 3_5000_000 bytes returns: "3.5 MB" for EN or "3.5 Mo" for FR.
     *
     * @param bytes The size in bytes to format.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    fun fileSize(bytes: Long, decimals: Int = 1): String {
        return safelyTranslate { formatFileSize(bytes, decimals) }
    }

    /**
     * Returns the given [number] in a short human-readable format.
     *
     * Supported abbreviations: K (1,000), M (1,000,000), B (1,000,000,000) and T (1,000,000,000,000).
     *
     * For example: 10394 returns "10K" and "4234321" returns "4M".
     */
    fun abbreviation(number: Number, decimals: Int = 0): String {
        return safelyTranslate { formatAbbreviation(number.toDouble(), decimals) }
    }

    /**
     * Formats the given [number].
     *
     * For example: 1_000_000.34 returns:
     * - "1,000,000.34" for EN
     * - "1 000 000.34" for FR
     * - "1.000.000,34" for NL
     */
    fun number(number: Number, decimals: Int = 0): String {
        return safelyTranslate { number.toDouble().formatNumber(decimals) }
    }
}