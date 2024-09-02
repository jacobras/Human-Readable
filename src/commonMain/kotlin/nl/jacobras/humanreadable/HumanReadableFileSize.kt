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
            "${(bytes / 1_024.0).formatNumber(decimals)} ${Res.string.kilobyte_symbol}"
        }
        bytes < 1.07374182E9 -> {
            "${(bytes / 1_048_576.0).formatNumber(decimals)} ${Res.string.megabyte_symbol}"
        }
        bytes < 1.09951163E12 -> {
            "${(bytes / 1.07374182E9).formatNumber(decimals)} ${Res.string.gigabyte_symbol}"
        }
        else -> {
            "${(bytes / 1.09951163E12).formatNumber(decimals)} ${Res.string.terabyte_symbol}"
        }
    }
}