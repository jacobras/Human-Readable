@file:Suppress("unused")

package nl.jacobras.humanreadable

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import nl.jacobras.humanreadable.HumanReadable.duration
import nl.jacobras.humanreadable.HumanReadable.fallbackLanguageTag
import nl.jacobras.humanreadable.HumanReadable.languageTag
import nl.jacobras.humanreadable.HumanReadable.number
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.Localisation
import nl.jacobras.humanreadable.time.*
import kotlin.time.Clock
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * A collection of data formatting utilities.
 */
public object HumanReadable {

    internal val localisation = Localisation()
    internal val strings: HumanReadableStrings
        get() = localisation.currentStrings

    /**
     * The language tag (e.g. `"en"`, `"fr"`) to use when formatting. Defaults to the detected system
     * language when it is supported, otherwise [fallbackLanguageTag].
     */
    public var languageTag: String
        get() = localisation.languageTag
        set(value) {
            localisation.requestedLanguageTag = value
        }

    /**
     * The fallback language tag (e.g. `"en"`, `"fr"`) to use when [languageTag] is not supported.
     * If an unsupported language is passed in, nothing changes.
     *
     * Defaults to English.
     */
    public var fallbackLanguageTag: String
        get() = localisation.fallbackLanguageTag
        set(value) {
            localisation.fallbackLanguageTag = value
        }

    /**
     * Returns the difference between [baseInstant] and [instant], in human-readable format. Also supports
     * instants in the future. For example, an instant that's 5 hours ago will return "5 hours ago".
     *
     * @param instant The [Instant] to format.
     * @param baseInstant The base/starting [Instant], defaulting to "now".
     * @param formatStyle The [FormatStyle] to use, defaulting to [FormatStyle.Regular].
     * @param timeZone If set, today/tomorrow/yesterday will be used.
     * @param parts Configures the formatting of multiple parts, defaulting to 1 part.
     * @param units The [TimeUnit]s to limit to during formatting, not limited by default.
     * @param rounding The [Rounding] strategy to use, defaulting to [Rounding.HalfUp].
     * @return a formatted string
     */
    @OptIn(ExperimentalTime::class)
    public fun timeAgo(
        instant: Instant,
        baseInstant: Instant = Clock.System.now(),
        formatStyle: FormatStyle = FormatStyle.Regular,
        timeZone: TimeZone? = null,
        parts: Parts = Parts(),
        units: Set<TimeUnit> = TimeUnit.all,
        rounding: Rounding = Rounding.HalfUp
    ): String {
        if (timeZone != null) {
            val localDate = instant.toLocalDateTime(timeZone).date
            val today = Clock.System.todayIn(timeZone)

            when (localDate) {
                today.minus(1, DateTimeUnit.DAY) -> return strings.dateTime.yesterday
                today -> return strings.dateTime.today
                today.plus(1, DateTimeUnit.DAY) -> return strings.dateTime.tomorrow
            }
        }

        return formatTimeAgo(
            instant = instant,
            baseInstant = baseInstant,
            formatStyle = formatStyle,
            timeZone = timeZone,
            parts = parts,
            units = units,
            rounding = rounding

        )
    }

    /**
     * Returns the given [duration] in human-readable format.
     * For example, a duration of 3 seconds returns "3 seconds".
     *
     * @param duration The [Duration] to format.
     * @param formatStyle The [FormatStyle] to use, defaulting to [FormatStyle.Regular].
     * @param parts Configures the formatting of multiple parts, defaulting to 1 part.
     * @param units The [TimeUnit]s to limit to during formatting, not limited by default.
     * @param rounding The [Rounding] strategy to use, defaulting to [Rounding.HalfUp].
     */
    public fun duration(
        duration: Duration,
        formatStyle: FormatStyle = FormatStyle.Regular,
        parts: Parts = Parts(),
        units: Set<TimeUnit> = TimeUnit.all,
        rounding: Rounding = Rounding.HalfUp
    ): String {
        return formatDuration(
            duration = duration,
            relativeTime = RelativeTime.Present,
            formatStyle = formatStyle,
            parts = parts,
            units = units,
            rounding = rounding
        )
    }

    /**
     * Returns the given [bytes] size in human-readable format. For example,
     * a size of 3_500_000 bytes returns "3.5 MB". Assumes base 1024.
     *
     * For example, `3_5000_000` returns: "3.5 MB" for EN or "3.5 Mo" for FR.
     *
     * @param bytes The size in bytes to format.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    public fun fileSize(bytes: Long, decimals: Int = 1): String {
        return formatFileSize(bytes, decimals)
    }

    /**
     * Returns the given [number] in a short human-readable format.
     *
     * Supported abbreviations: K (1,000), M (1,000,000), B (1,000,000,000) and T (1,000,000,000,000).
     *
     * For example, `10394` returns "10K" and `4234321` returns "4M".
     *
     * @param number The number to abbreviate.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    public fun abbreviation(number: Number, decimals: Int = 0): String {
        return formatAbbreviation(number.toDouble(), decimals)
    }

    /**
     * Formats the given [number].
     *
     * For example, `1_000_000.34` returns:
     * - "1,000,000.34" for EN
     * - "1 000 000.34" for FR
     * - "1.000.000,34" for NL
     *
     * @param number The number to format.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    public fun number(number: Number, decimals: Int = 0): String {
        return number.toDouble().formatNumber(decimals)
    }

    /**
     * Formats the given [value] of the given [unit] to a readable distance.
     *
     * Metric examples:
     * - `956` with DistanceUnit METERS returns "956 m" for EN.
     * - `1534` with DistanceUnit METERS returns "1,5 km" for EN.
     *
     * Imperial examples:
     * - `5200` with DistanceUnit FEET returns "5,200 ft" for EN.
     * - `5350` returns with DistanceUnit FEET returns "1.0 mi" for EN.
     *
     * In other languages, the numbers are formatted accordingly, see [number].
     *
     * Note that meters and feet are always formatted with 0 decimals.
     * Kilometers and miles are formatted according to [decimals].
     *
     * @param value The distance to format.
     * @param unit The [DistanceUnit] the given [value] is in.
     * @param decimals The number of decimals to use in formatting larger than meters/feet.
     * @return a formatted string
     */
    public fun distance(value: Number, unit: DistanceUnit, decimals: Int = 1): String {
        return formatDistance(value, unit, decimalsForLargeUnits = decimals)
    }
}