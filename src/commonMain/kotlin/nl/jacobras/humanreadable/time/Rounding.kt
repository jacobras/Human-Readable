package nl.jacobras.humanreadable.time

public sealed interface Rounding {

    /**
     * Rounds down.
     *
     * Some examples:
     * - `11.days` results in "1 week".
     * - `13.days` results in "1 week".
     * - `14.days` results in "2 weeks".
     */
    public data object Floor : Rounding

    /**
     * Rounds up.
     *
     * Some examples:
     * - `11.days` results in "2 weeks".
     * - `13.days` results in "2 weeks".
     * - `14.days` results in "2 weeks".
     */
    public data object HalfUp : Rounding

    /**
     * Rounds up if the duration is close to the next unit.
     *
     * "Close" is defined as:
     * - `55.seconds` rounds up to a minute
     * - `55.minutes` rounds up to an hour
     * - `23.hours` rounds up to a day
     *
     * Larger units are rounded half up, e.g. 10.5 days rounds up to 11 days.
     */
    public data object UpIfClose : Rounding
}