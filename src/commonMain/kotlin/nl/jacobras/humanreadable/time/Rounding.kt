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
}