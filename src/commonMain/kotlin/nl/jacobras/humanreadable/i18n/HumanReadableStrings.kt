package nl.jacobras.humanreadable.i18n

/**
 * All localised strings for a single language, grouped per type.
 */
internal data class HumanReadableStrings(
    val dateTime: DateTimeStrings,
    val number: NumberStrings = NumberStrings(),
    val fileSize: FileSizeStrings = FileSizeStrings(),
    val distance: DistanceStrings = DistanceStrings()
)

/**
 * Relative-time and duration strings.
 */
internal data class DateTimeStrings(
    /**
     * Resolves a count to its plural category for this language.
     *
     * See [Unicode Plural Rules](https://www.unicode.org/cldr/charts/48/supplemental/language_plural_rules.html).
     */
    val plural: (Int) -> Plural,

    val secondsLong: TenseForms,
    val minutesLong: TenseForms,
    val hoursLong: TenseForms,
    val daysLong: TenseForms,
    val weeksLong: TenseForms,
    val monthsLong: TenseForms,
    val yearsLong: TenseForms,

    // TODO: remove defaults
    val secondsShort: TenseForms = presentTense(one = "hr"),
    val minutesShort: TenseForms = presentTense(one = "h"),
    val hoursShort: TenseForms = presentTense(one = "day", other = "days"),
    val daysShort: TenseForms = presentTense(one = "day", other = "days"),
    val weeksShort: TenseForms = presentTense(one = "d"),
    val monthsShort: TenseForms = presentTense(one = "week", other = "weeks"),
    val yearsShort: TenseForms = presentTense(one = "wk", other = "wks"),

    // TODO: remove defaults
    val secondsNarrow: TenseForms = presentTense(one = "w"),
    val minutesNarrow: TenseForms = presentTense(one = "month", other = "months"),
    val hoursNarrow: TenseForms = presentTense(one = "mth", other = "mths"),
    val daysNarrow: TenseForms = presentTense(one = "m"),
    val weeksNarrow: TenseForms = presentTense(one = "year", other = "years"),
    val monthsNarrow: TenseForms = presentTense(one = "yr", other = "yrs"),
    val yearsNarrow: TenseForms = presentTense(one = "y"),

    /**
     * Wraps a formatted duration as past relative time, e.g. "3 days ago".
     */
    val timeAgo: (String) -> String,

    /**
     * Wraps a formatted duration as future relative time, e.g. "in 3 days".
     */
    val timeInFuture: (String) -> String,

    val now: String,
    val today: String,
    val yesterday: String,
    val tomorrow: String,
    val lessThan: String = "!!TODO",
    val about: String = "!!TODO"
)

/**
 * Number-formatting symbols.
 *
 * Only override what differs from the default values.
 */
internal data class NumberStrings(
    /**
     * Separator used for grouping thousands.
     */
    val groupSeparator: String = ",",

    val decimalSymbol: String = "."
)

/**
 * File-size unit symbols.
 *
 * Only override what differs from the default values.
 */
internal data class FileSizeStrings(
    val byteSymbol: String = "B",
    val kilobyteSymbol: String = "kB",
    val megabyteSymbol: String = "MB",
    val gigabyteSymbol: String = "GB",
    val terabyteSymbol: String = "TB"
)

/**
 * Distance unit abbreviations.
 *
 * Only override what differs from the default values.
 */
internal data class DistanceStrings(
    val meterAbbreviation: String = "m",
    val kilometerAbbreviation: String = "km",
    val feetAbbreviation: String = "ft",
    val mileAbbreviation: String = "mi"
)