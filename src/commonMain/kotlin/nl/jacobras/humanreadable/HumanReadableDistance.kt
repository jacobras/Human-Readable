package nl.jacobras.humanreadable

/**
 * Returns the given distance [distance] in human-readable format.
 */
internal expect fun formatDistance(
    distance: Int,
    type: DistanceType = DistanceType.METERS
): String

public enum class DistanceType {
    METERS, FEET
}