package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.HumanReadable.abbreviation

/**
 * Returns the given [number] formatted with metric prefix. For a more common short number, see [abbreviation].
 * Starts at k for 1000 and goes up until E (exa), 10^18.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Metric_prefix">Wikipedia: Metric prefix</a>
 */
internal fun formatMetricPrefix(number: Double, decimals: Int): String {
    var current = number.toFloat()
    var bigIndex = 0
    var smallIndex = 0

    while (current >= 1000 && bigIndex < bigPrefixes.size - 1) {
        current /= 1000
        bigIndex++
    }

    while (current < 0.01) {
        current *= 1000
        smallIndex--
    }

    return if (smallIndex > 0) {
        "${current.formatWithDecimals(decimals)}${smallPrefixes[bigIndex]}"
    } else {
        "${current.formatWithDecimals(decimals)}${bigPrefixes[bigIndex]}"
    }
}

private val bigPrefixes = arrayOf("", "k", "M", "G", "T", "P", "E", "Z", "Y", "R", "Q")
private val smallPrefixes = arrayOf("", "k", "M", "G", "T", "P", "E", "Z", "Y", "R", "Q")