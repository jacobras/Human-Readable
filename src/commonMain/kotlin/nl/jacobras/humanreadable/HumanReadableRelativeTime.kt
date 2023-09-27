package nl.jacobras.humanreadable

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import nl.jacobras.humanreadable.i18n.HumanLocale

/**
 * Returns the difference between now and [instant], in human-readable format.
 * Also supports instants in the future.
 */
internal fun formatTimeAgo(locale: HumanLocale, instant: Instant): String {
    val now = Clock.System.now()
    val diff = now - instant
    val secondsAgo = diff.inWholeSeconds

    return when {
        secondsAgo < 0 -> {
            locale.timeInFuture.replace("%time%", formatDuration(locale, diff.absoluteValue))
        }
        secondsAgo <= 1 -> {
            locale.now
        }
        else -> locale.timeAgo.replace("%time%", formatDuration(locale, diff))
    }
}