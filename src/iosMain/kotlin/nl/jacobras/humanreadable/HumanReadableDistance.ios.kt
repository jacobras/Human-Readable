package nl.jacobras.humanreadable

import platform.Foundation.NSString
import platform.Foundation.stringWithFormat

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
        meters < 1000 -> formatString("%.0f m", meters)  // Use meters
        else -> formatString("%.1f km", meters / 1000)   // Convert to kilometers
    }
}

private fun toImperial(feet: Float): String {
    return when {
        feet < 5280 -> formatString("%.0f ft", feet)  // Less than a mile, use feet
        else -> formatString("%.1f mi", feet / 5280) // Convert to miles
    }
}

private fun formatString(format: String, arg: Float): String {
    return NSString.stringWithFormat(format, arg)
}