package nl.jacobras.humanreadable

import HumanReadableRes as Res

/**
 * Returns the given distance [value] in human-readable format.
 *
 * @param value The distance to format.
 * @param unit The [DistanceUnit] the given [value] is in.
 * @param decimalsForLargeUnits The number of decimals to use in formatting larger than meters/feet.
 * @return a formatted string
 */
internal fun formatDistance(
    value: Int,
    unit: DistanceUnit = DistanceUnit.Meter,
    decimalsForLargeUnits: Int
): String {
    return when (unit) {
        DistanceUnit.Meter -> toMetric(value.toDouble(), decimalsForLargeUnits = decimalsForLargeUnits)
        DistanceUnit.Foot -> toImperial(value.toDouble(), decimalsForLargeUnits = decimalsForLargeUnits)
    }
}

private fun toMetric(meters: Double, decimalsForLargeUnits: Int): String {
    return if (meters < 1000) {
        // Use meters
        meters.formatNumber(decimals = 0) + " " + Res.string.meter_abbreviation
    } else {
        // Convert to kilometers
        (meters / 1000).formatNumber(decimals = decimalsForLargeUnits) + " " + Res.string.kilometer_abbreviation
    }
}

private fun toImperial(feet: Double, decimalsForLargeUnits: Int): String {
    return if (feet < MILE_IN_FEET) {
        // Less than a mile, use feet
        feet.formatNumber(decimals = 0) + " " + Res.string.feet_abbreviation
    } else {
        // Convert to miles
        (feet / MILE_IN_FEET).formatNumber(decimals = decimalsForLargeUnits) + " " + Res.string.mile_abbreviation
    }
}

public enum class DistanceUnit {
    Meter,
    Foot
}

private const val MILE_IN_FEET = 5280