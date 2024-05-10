package nl.jacobras.humanreadable

import Res

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