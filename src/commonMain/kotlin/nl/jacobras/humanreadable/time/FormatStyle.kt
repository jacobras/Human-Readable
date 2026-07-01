package nl.jacobras.humanreadable.time

/**
 * Determines the format style of the output.
 *
 * @property date The date notation to use.
 * @property time The time notation to use.
 * @property indicateApproximation Whether to indicate that the output is approximate (e.g. "about 5 minutes ago").
 */
public data class FormatStyle(
    val date: Date = Date.Long,
    val time: Time = Time.Regular,
    val indicateApproximation: Boolean = false
) {

    public enum class Date {

        /**
         * Long format style, e.g. "1 hour, 50 minutes".
         */
        Long,

        /**
         * Shorter format style, e.g. "1 hr, 50 min".
         */
        Short,

        /**
         * Shortest format style, e.g. "1h 50m".
         */
        Narrow
    }

    public enum class Time {

        /**
         * Regular format style, e.g. "1 hour, 50 minutes".
         */
        Regular,

        /**
         * Digital format style, e.g. "1:50:00".
         */
        Digital
    }
}