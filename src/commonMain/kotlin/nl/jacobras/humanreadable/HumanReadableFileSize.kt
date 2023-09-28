package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.i18n.HumanLocale
import kotlin.math.pow
import kotlin.math.roundToLong

/**
 * Returns the given [bytes] size in human-readable format.
 */
internal fun formatFileSize(locale: HumanLocale, bytes: Long, decimals: Int): String {
    return when {
        bytes < 1024 -> {
            "$bytes B"
        }
        bytes < 1_048_576 -> {
            "${(bytes / 1_024f).formatWithDecimals(decimals)} kB"
        }
        bytes < 1.07374182E9f -> {
            "${(bytes / 1_048_576f).formatWithDecimals(decimals)} MB"
        }
        bytes < 1.09951163E12f -> {
            "${(bytes / 1.07374182E9f).formatWithDecimals(decimals)} GB"
        }
        else -> {
            "${(bytes / 1.09951163E12f).formatWithDecimals(decimals)} TB"
        }
    }
}

private fun Float.formatWithDecimals(decimals: Int): String {
    val multiplier = 10.0.pow(decimals)
    val numberAsString = (this * multiplier).roundToLong().toString()
    val decimalIndex = numberAsString.length - decimals - 1
    val mainRes = numberAsString.substring(0..decimalIndex)
    val fractionRes = numberAsString.substring(decimalIndex + 1)
    return if (fractionRes.isEmpty()) {
        mainRes
    } else {
        "$mainRes.$fractionRes"
    }
}