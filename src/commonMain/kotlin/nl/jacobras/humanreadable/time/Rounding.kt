package nl.jacobras.humanreadable.time

/**
 * Rounding method.
 *
 * Note about multi-parts (when [PartsConfig.max] > 1): rounding is done on the smallest included unit.
 */
public sealed interface Rounding {

    /**
     * Either [Floor] or [HalfUp]. Marker interface to use with [IfClose].
     */
    public sealed interface Simple : Rounding

    /**
     * Rounds down.
     *
     * Some examples:
     * - `12.days` results in "1 week".
     * - `46.days` results in "1 month".
     */
    public data object Floor : Simple

    /**
     * Rounds up.
     *
     * Some examples:
     * - `12.days` results in "2 weeks".
     * - `46.days` results in "2 months".
     *
     * Note that when [PartsConfig.max] is larger than 1, the rounding is done on the smallest unit.
     */
    public data object HalfUp : Simple

    /**
     * Eagerly rounds up to the next unit, or down to the previous, if within [thresholds].
     *
     * For example, with [PartsConfig.max] set to 2 and [thresholds] set to [Seconds = 5]:
     * - `1.minutes + 5.seconds` remains "1 minute, 5 seconds";
     * - `1.minutes + 4.seconds` gets rounded to "1 minute";
     * - `1.minutes + 54.seconds` remains "1 minute, 54 seconds";
     * - `1.minutes + 55.seconds` gets rounded to "2 minutes".
     *
     * Anything else is rounded according to [default], which defaults to [Floor].
     */
    public data class IfClose(
        val thresholds: Map<TimeUnit, Int> = mapOf(
            TimeUnit.Seconds to 5,
            TimeUnit.Minutes to 5,
            TimeUnit.Hours to 1,
            TimeUnit.Days to 1
        ),
        val default: Simple = Floor
    ) : Rounding
}