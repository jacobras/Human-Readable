package nl.jacobras.humanreadable

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Returns the given distance [value] in human-readable format.
 */
internal fun formatDistance(
    value: Int,
    unit: DistanceUnit = DistanceUnit.METERS
): String {
    return when (unit) {
        DistanceUnit.METERS -> toMetric(value.toFloat())
        DistanceUnit.FEET -> toImperial(value.toFloat())
    }
}

private fun toMetric(meters: Float): String {
    return when {
        meters < 1000 -> formatNumber(meters, 0) + " m" // Use meters
        else -> formatNumber(meters / 1000, 1) + " km" // Convert to kilometers
    }
}

private fun toImperial(feet: Float): String {
    return when {
        feet < 5280 -> formatNumber(value = feet, 0) + " ft"  // Less than a mile, use feet
        else -> formatNumber(value = feet / 5280, 1) + " mi" // Convert to miles
    }
}

private fun formatNumber(value: Float, decimalPlaces: Int): String {
    val result = when (decimalPlaces) {
        0 -> value.roundToInt()
        else -> {
            val factor = 10.0.pow(decimalPlaces)
            (value * factor) / factor
        }
    }
    val separatorIndex = result.toString().indexOf(".")
    val isSeparatorFound = separatorIndex > 0
    if (isSeparatorFound) {
        val substringAccordingToDecimalPlaces = when (decimalPlaces) {
            0 -> result.toString().substring(0, separatorIndex)
            else -> result.toString().substring(0, separatorIndex + 1 + decimalPlaces)
        }
        return substringAccordingToDecimalPlaces
    } else {
        return result.toString()
    }
}

public enum class DistanceUnit {
    METERS, FEET
}