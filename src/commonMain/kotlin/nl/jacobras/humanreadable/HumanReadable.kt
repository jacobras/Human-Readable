package nl.jacobras.humanreadable

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.math.roundToInt

object HumanReadable {

    fun timeAgo(instant: Instant): String {
        val now = Clock.System.now()
        val diff = now - instant
        val secondsAgo = diff.inWholeSeconds
        val daysAgo = diff.inWholeDays
        val weeksAgo = diff.inWholeDays / 7f
        val monthsAgo = diff.inWholeDays / 30.5f
        val yearsAgo = diff.inWholeDays / 365

        return when {
            secondsAgo < 0 -> {
                "in the future"
            }

            secondsAgo <= 1 -> {
                "now"
            }

            secondsAgo < 60 -> {
                "$secondsAgo seconds ago"
            }

            secondsAgo < 3600 -> {
                "${diff.inWholeMinutes} minutes ago"
            }

            daysAgo < 1 -> {
                "${diff.inWholeHours} hours ago"
            }

            daysAgo < 7 -> {
                "$daysAgo days ago"
            }

            daysAgo < 30 -> {
                "${weeksAgo.roundToInt()} weeks ago"
            }

            monthsAgo < 12 -> {
                "${monthsAgo.roundToInt()} months ago"
            }

            else -> {
                "$yearsAgo years ago"
            }
        }
    }
}