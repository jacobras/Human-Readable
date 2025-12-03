package nl.jacobras.humanreadable

import HumanReadableRes as Res
import kotlin.math.pow
import kotlin.math.roundToLong

internal fun Double.formatNumber(
    decimals: Int
): String {
    val groupSeparator = Res.string.groupSeparator.formatWithSpaceIfNeeded()
    val decimalSymbol = Res.string.decimalSymbol
    val rounded = formatWithDecimals(decimals)
    val parts = rounded.split('.')

    val integerPart = parts[0]
    // Check is Negative
    val isNegative = integerPart.startsWith("-")

    // If Negative Then drop first letter
    val numberPart = if (isNegative) integerPart.substring(1) else integerPart

    // Format the integer part
    val formattedNumberPart = numberPart
        .reversed()
        .chunked(3)
        .joinToString(groupSeparator)
        .reversed()

    val formattedIntegerPart = if (isNegative) "-$formattedNumberPart" else formattedNumberPart


    // Format the decimal part
    val decimalPart = if (parts.size > 1) parts[1] else ""
    val formattedDecimalPart = if (decimals > 0) {
        val truncatedDecimals = decimalPart.padEnd(decimals, '0').substring(0, decimals)
        decimalSymbol + truncatedDecimals
    } else {
        ""
    }

    return formattedIntegerPart + formattedDecimalPart
}

private fun Double.formatWithDecimals(decimals: Int): String {
    val multiplier = 10.0.pow(decimals)
    val numberAsString = (this * multiplier).roundToLong().toString().padStart(decimals + 1, '0')
    val decimalIndex = numberAsString.length - decimals - 1
    val mainRes = numberAsString.substring(0..decimalIndex)
    val fractionRes = numberAsString.substring(decimalIndex + 1)
    return if (fractionRes.isEmpty()) {
        mainRes
    } else {
        "$mainRes.$fractionRes"
    }
}

/**
 * Workaround for Libres returning an empty string if it contains only a space.
 */
private fun String.formatWithSpaceIfNeeded(): String {
    return ifEmpty { " " }
}