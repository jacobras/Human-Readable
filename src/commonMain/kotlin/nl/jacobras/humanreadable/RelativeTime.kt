package nl.jacobras.humanreadable

/**
 * Indicates in what time frame the requested time unit needs
 * to be localised. Used to support grammar cases in languages like German.
 */
enum class RelativeTime {
    Past, Present, Future
}