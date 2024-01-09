package nl.jacobras.humanreadable

import Res
import kotlin.math.pow
import kotlin.math.roundToLong

/**
 * Returns the given [bytes] size in human-readable format.
 */
internal fun formatFileSize(bytes: Long, decimals: Int): String {
    return when {
        bytes < 1024 -> {
            "$bytes ${Res.string.byte_symbol}"
        }
        bytes < 1_048_576 -> {
            "${(bytes / 1_024f).formatWithDecimals(decimals)} ${Res.string.kilobyte_symbol}"
        }
        bytes < 1.07374182E9f -> {
            "${(bytes / 1_048_576f).formatWithDecimals(decimals)} ${Res.string.megabyte_symbol}"
        }
        bytes < 1.09951163E12f -> {
            "${(bytes / 1.07374182E9f).formatWithDecimals(decimals)} ${Res.string.gigabyte_symbol}"
        }
        else -> {
            "${(bytes / 1.09951163E12f).formatWithDecimals(decimals)} ${Res.string.terabyte_symbol}"
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