package nl.jacobras.humanreadable

/**
 * Returns the given distance [distance] in human-readable format.
 */
expect internal fun formatDistance(
    distance: Int,
    type: DistanceType = DistanceType.METERS
): String

internal enum class DistanceType {
    METERS, FEET
}