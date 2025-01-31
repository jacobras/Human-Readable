package nl.jacobras.humanreadable

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
        meters < 1000 -> String.format("%.0f m", meters)  // Use meters
        else -> String.format("%.1f km", meters / 1000)   // Convert to kilometers
    }
}

private fun toImperial(feet: Float): String {
    return when {
        feet < 5280 -> String.format("%.0f ft", feet)  // Less than a mile, use feet
        else -> String.format("%.1f mi", feet / 5280) // Convert to miles
    }
}