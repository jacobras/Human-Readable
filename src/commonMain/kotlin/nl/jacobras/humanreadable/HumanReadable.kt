@file:Suppress("unused")

package nl.jacobras.humanreadable

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
    fun timeAgo(instant: Instant): String {
        return formatTimeAgo(instant)
    }

    /**
     * Returns the given [duration] in human-readable format.
     * For example: a duration of 3 seconds returns "3 seconds".
     *
     * @param duration The [Duration] to format.
     * @return a formatted string
     */
    fun duration(duration: Duration): String {
        return formatDuration(duration)
    }

    /**
     * Returns the given [bytes] size in human-readable format. For example:
     * a size of 3_500_000 bytes returns "3.5 MB". Assumes base 1024.
     *
     * @param bytes The size in bytes to format.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    fun fileSize(bytes: Long, decimals: Int = 1): String {
        return formatFileSize(bytes, decimals)
    }

    /**
     * Returns the given [number] in a short human-readable format. For the metric prefix, see [metricPrefix].
     *
     * Supported abbreviations: K (1,000), M (1,000,000), B (1,000,000,000) and T (1,000,000,000,000).
     *
     * For example: 10394 returns "10K" and "4234321" returns "4M".
     * Goes up until B (billion) and T (trillion).
     */
    fun abbreviation(number: Number, decimals: Int = 0): String {
        return formatAbbreviation(number, decimals)
    }

    /**
     * Returns the given [number] formatted with metric prefix. For a more common short number, see [abbreviation].
     * Starts at k for 1000 and goes up until Q (quetta), 10^30.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Metric_prefix">Wikipedia: Metric prefix</a>
     */
    fun metricPrefix(number: Double, decimals: Int = 0): String {
        return formatMetricPrefix(number, decimals)
    }
}