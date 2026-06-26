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
    val seconds: TenseForms,
    val minutes: TenseForms,
    val hours: TenseForms,
    val days: TenseForms,
    val weeks: TenseForms,
    val months: TenseForms,
    val years: TenseForms,

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
    val tomorrow: String
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