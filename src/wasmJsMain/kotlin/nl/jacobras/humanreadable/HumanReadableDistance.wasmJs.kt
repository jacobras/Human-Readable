package nl.jacobras.humanreadable

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Returns the given distance [distance] in human-readable format.
 */
internal actual fun formatDistance(
    distance: Int,
    type: DistanceType
): String {
    return when (type) {
        DistanceType.METERS -> toMetric(distance.toFloat())
        DistanceType.FEET -> toImperial(distance.toFloat())
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
    val factor = 10.0.pow(decimalPlaces)
    val result =
        if (decimalPlaces == 0) ((value * factor).roundToInt() / factor).toInt() else ((value * factor).roundToInt() / factor)
    return result.toString()
}