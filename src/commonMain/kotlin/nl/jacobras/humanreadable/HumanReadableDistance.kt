package nl.jacobras.humanreadable

/**
 * Returns the given distance [value] in human-readable format.
 */
internal fun formatDistance(
    value: Int,
    unit: DistanceUnit = DistanceUnit.METERS
): String {
    return when (unit) {
        DistanceUnit.METERS -> toMetric(value.toDouble())
        DistanceUnit.FEET -> toImperial(value.toDouble())
    }
}

private fun toMetric(meters: Double): String {
    return if (meters < 1000) {
        // Use meters
        meters.formatNumber(decimals = 0) + " m"
    } else {
        // Convert to kilometers
        (meters / 1000).formatNumber(decimals = 1) + " km"
    }
}

private fun toImperial(feet: Double): String {
    return if (feet < MILE_IN_FEET) {
        // Less than a mile, use feet
        feet.formatNumber(decimals = 0) + " ft"
    } else {
        // Convert to miles
        (feet / MILE_IN_FEET).formatNumber(decimals = 1) + " mi"
    }
}

public enum class DistanceUnit {
    METERS, FEET
}

private const val MILE_IN_FEET = 5280