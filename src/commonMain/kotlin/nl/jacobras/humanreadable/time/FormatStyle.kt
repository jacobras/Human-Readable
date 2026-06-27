package nl.jacobras.humanreadable.time

public enum class FormatStyle {

    /**
     * The default format style, e.g. "1 hour ago".
     */
    Long,

    /**
     * Same as [Long], but with an approxmiation word added if the duration is not exact.
     *
     * For example, with `Parts` configured to show max. 1 part:
     * - `1.hours` will be "1 hour";
     * - `1.hours + 1.minutes` will be "about 1 hour";
     * - `1.hours + 59.minutes` will be "about 1 hour" (with `Floor` rounding).
     */
    LongApproximate,

    /**
     * Shorter format for limited space.
     *
     * Examples:
     * - Time: "1 hr, 50 min"
     * - Time and date: "3 wks, 4 days, 1 hr, 50 min"
     */
    Short,

    /**
     * Like [Short], but with digital time.
     *
     * Examples:
     * - Time: "1:50:00"
     * - Time and date: "3 wks, 4 days, 1:50:00"
     */
    ShortDigital,

    /**
     * Shortest format for limited space.
     *
     * Examples:
     * - Time: "1h 50m"
     * - Time and date: "3w, 4d, 1h 50m"
     */
    Narrow,

    /**
     * Like [Narrow], but with digital time.
     *
     * Examples:
     * - Time: "1:50:00"
     * - Time and date: "3w, 4d, 1:50:00"
     */
    NarrowDigital
}