package nl.jacobras.humanreadable.time

public enum class FormatStyle {

    /**
     * The default format style, e.g. "1 hour ago".
     */
    Regular,

    /**
     * Same as [Regular], but with an approxmiation word added if the duration is not exact.
     *
     * For example, with `Parts` configured to show max. 1 part):
     * - `1.hours` will be "1 hour";
     * - `1.hours + 1.minutes` will be "about 1 hour";
     * - `1.hours + 59.minutes` will be "about 1 hour" (with `Floor` rounding).
     */
    WithApproximation,

    /**
     * Shorter format for limited space, e.g. "1h ago" or "10mo ago"
     */
    Abbreviated
}