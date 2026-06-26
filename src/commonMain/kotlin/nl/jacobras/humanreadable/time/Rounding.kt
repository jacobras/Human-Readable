package nl.jacobras.humanreadable.time

public sealed interface Rounding {

    /**
     * Rounds down.
     *
     * Some examples:
     * - `12.days` results in "1 week".
     * - `46.days` results in "1 month".
     */
    public data object Floor : Rounding

    /**
     * Rounds up.
     *
     * Some examples:
     * - `12.days` results in "2 weeks".
     * - `46.days` results in "2 months".
     */
    public data object HalfUp : Rounding

    /**
     * Rounds up if the duration is close to the next unit.
     *
     * "Close" is defined as:
     * - `55.seconds` rounds up to a minute.
     * - `55.minutes` rounds up to an hour.
     * - `23.hours` rounds up to a day.
     * - `13.days` rounds up to two weeks.
     *
     * Anything else is rounded **down**.
     */
    public data object UpIfClose : Rounding
}