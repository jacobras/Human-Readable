@file:Suppress("unused")

package nl.jacobras.humanreadable

import kotlinx.datetime.Instant
import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanLocales
import nl.jacobras.humanreadable.i18n.LocaleMatcher
import kotlin.time.Duration

/**
 * A collection of data formatting utilities.
 */
object HumanReadable {
    internal var locale: HumanLocale = HumanLocales.Default.locale
        private set

    /**
     * Changes the locale for all method calls after this.
     *
     * @param locale The IETF language code, e.g. "en-GB".
     */
    fun setLocale(locale: String) {
        val code = LocaleMatcher.lookup(
            options = HumanLocales.entries.map { it.locale.code },
            input = locale,
            default = HumanLocales.Default.locale.code
        )
        setLocale(HumanLocales.entries.first { it.locale.code == code }.locale)
    }

    /**
     * Changes the locale for all method calls after this.
     *
     * @param locale The locale to set, obtained from [HumanLocales].
     */
    fun setLocale(locale: HumanLocale) {
        this.locale = locale
    }

    /**
     * Returns the difference between now and [instant], in human-readable format. Also supports
     * instants in the future. For example: an instant that's 5 hours ago will return "5 hours ago".
     *
     * @param instant The [Instant] to format.
     * @return a formatted string
     */
    fun timeAgo(instant: Instant): String {
        return formatTimeAgo(instant)
    }

    /**
     * Returns the given [duration] in human-readable format.
     * For example: a duration of 3 seconds returns "3 seconds".
     *
     * @param duration The [Duration] to format.
     * @return a formatted string
     */
    fun duration(duration: Duration): String {
        return formatDuration(duration)
    }

    /**
     * Returns the given [bytes] size in human-readable format. For example:
     * a size of 3_500_000 bytes returns "3.5 MB". Assumes base 1024.
     *
     * @param bytes The size in bytes to format.
     * @param decimals The number of decimals to use in formatting.
     * @return a formatted string
     */
    fun fileSize(bytes: Long, decimals: Int = 1): String {
        return formatFileSize(bytes, decimals)
    }
}