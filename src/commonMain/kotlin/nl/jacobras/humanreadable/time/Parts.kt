package nl.jacobras.humanreadable.time

import kotlin.time.Duration

/**
 * Configures the formatting of multiple parts when formatting a duration.
 *
 * Note that only adjacent subparts are used:
 * - "1 day, 20 hours" could be output;
 * - "1 day, 20 minutes" will never be output (because minutes are not next to days).
 */
public data class Parts(

    /**
     * Maximum number of parts to show.
     *
     * For example, `14.days + 5.hours + 6.minutes + 30.seconds` will be:
     * - "14 days, 5 hours, 6 minutes" if this is set to 3;
     * - "14 days, 5 hours" if this is set to 2;
     * - "14 days" if this is set to 1.
     */
    val max: Int = 1,

    /**
     * Smallest duration to show. Anything smaller than this will be shown as "less than x".
     *
     * For example, if this is set to `45.seconds`, then:
     * - `44.seconds` will be "less than 45 seconds"
     * - `45.seconds` will be "45 seconds"
     */
    val smallestDuration: Duration = Duration.ZERO,

    /**
     * Controls up to how many of [TimeUnit] smaller subparts should be shown.
     *
     * For example, if this is set to `[TimeUnit.Minutes = 2]`:
     * - `1.minutes + 4.seconds` will be "1 minute, 4 seconds"
     * - `2.minutes + 4.seconds` will be "2 minutes"
     *
     * If this is set to `[TimeUnit.Hours = 20]`:
     * - `19.hours + 4.minutes` will be "19 hours, 4 minutes"
     * - `20.hours + 4.minutes` will be "20 hours"
     */
    val subpartCutOffs: Map<TimeUnit, Int> = mapOf(
        TimeUnit.Minutes to 2,
        TimeUnit.Hours to 2,
        TimeUnit.Days to 2
    )
)