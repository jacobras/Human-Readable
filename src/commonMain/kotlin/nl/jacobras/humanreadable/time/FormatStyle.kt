package nl.jacobras.humanreadable.time

public enum class FormatStyle(
    internal val dateTimeUnits: DateTimeUnits,
    internal val timeStyle: TimeStyle,
    internal val approximation: Boolean
) {

    /**
     * The default format style, e.g. "1 hour ago".
     */
    Long(
        dateTimeUnits = DateTimeUnits.Long,
        timeStyle = TimeStyle.Regular,
        approximation = false
    ),

    /**
     * Same as [Long], but with an approxmiation word added if the duration is not exact.
     *
     * For example, with `Parts` configured to show max. 1 part:
     * - `1.hours` will be "1 hour";
     * - `1.hours + 1.minutes` will be "about 1 hour";
     * - `1.hours + 59.minutes` will be "about 1 hour" (with `Floor` rounding).
     */
    LongApproximate(
        dateTimeUnits = DateTimeUnits.Long,
        timeStyle = TimeStyle.Regular,
        approximation = true
    ),

    /**
     * Shorter format for limited space.
     *
     * Examples:
     * - Time: "1 hr, 50 min"
     * - Time and date: "3 wks, 4 days, 1 hr, 50 min"
     */
    Short(
        dateTimeUnits = DateTimeUnits.Short,
        timeStyle = TimeStyle.Regular,
        approximation = false
    ),

    /**
     * Like [Short], but with digital time.
     *
     * Examples:
     * - Time: "1:50:00"
     * - Time and date: "3 wks, 4 days, 1:50:00"
     */
    ShortDigital(
        dateTimeUnits = DateTimeUnits.Short,
        timeStyle = TimeStyle.Digital,
        approximation = false
    ),

    /**
     * Shortest format for limited space.
     *
     * Examples:
     * - Time: "1h 50m"
     * - Time and date: "3w, 4d, 1h 50m"
     */
    Narrow(
        dateTimeUnits = DateTimeUnits.Narrow,
        timeStyle = TimeStyle.Regular,
        approximation = false
    ),

    /**
     * Like [Narrow], but with digital time.
     *
     * Examples:
     * - Time: "1:50:00"
     * - Time and date: "3w, 4d, 1:50:00"
     */
    NarrowDigital(
        dateTimeUnits = DateTimeUnits.Narrow,
        timeStyle = TimeStyle.Digital,
        approximation = false
    );

    internal enum class DateTimeUnits { Long, Short, Narrow }
    internal enum class TimeStyle { Regular, Digital }
}