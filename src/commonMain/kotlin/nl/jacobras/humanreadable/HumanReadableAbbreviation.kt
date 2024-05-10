package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.HumanReadable.metricPrefix

/**
 * Returns the given [number] in a short human-readable format. For the metric prefix, see [metricPrefix].
 *
 * Supported abbreviations: K (1,000), M (1,000,000), B (1,000,000,000) and T (1,000,000,000,000).
 *
 * For example: 10394 returns "10K" and "4234321" returns "4M".
 * Goes up until B (billion) and T (trillion).
 */
internal fun formatAbbreviation(number: Number, decimals: Int): String {
    var current = number.toFloat()
    var index = 0

    while (current >= 1000 && index < prefixes.size - 1) {
        current /= 1000
        index++
    }

    return "${current.formatWithDecimals(decimals)}${prefixes[index]}"
}

private val prefixes = arrayOf("", "K", "M", "B", "T")