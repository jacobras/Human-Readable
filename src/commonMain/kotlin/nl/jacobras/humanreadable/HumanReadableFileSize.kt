package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.strings.strings

/**
 * Returns the given [bytes] size in human-readable format.
 */
internal fun formatFileSize(bytes: Long, decimals: Int): String {
    return when {
        bytes < 1024 -> {
            "$bytes ${strings.byteSymbol}"
        }
        bytes < 1_048_576 -> {
            "${(bytes / 1_024.0).formatNumber(decimals)} ${strings.kilobyteSymbol}"
        }
        bytes < 1.07374182E9 -> {
            "${(bytes / 1_048_576.0).formatNumber(decimals)} ${strings.megabyteSymbol}"
        }
        bytes < 1.09951163E12 -> {
            "${(bytes / 1.07374182E9).formatNumber(decimals)} ${strings.gigabyteSymbol}"
        }
        else -> {
            "${(bytes / 1.09951163E12).formatNumber(decimals)} ${strings.terabyteSymbol}"
        }
    }
}
