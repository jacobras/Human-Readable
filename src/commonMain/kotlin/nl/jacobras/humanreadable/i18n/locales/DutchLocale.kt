package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object DutchLocale : HumanLocale {
    override val code = "nl"

    override val timeAgo: String
        get() = "%time% geleden"
    override val timeInFuture: String
        get() = "over %time%"
    override val now: String
        get() = "nu"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "seconde" else "seconden"
            HumanTimeUnit.Minute -> if (quantity == 1L) "minuut" else "minuten"
            HumanTimeUnit.Hour -> if (quantity == 1L) "uur" else "uren"
            HumanTimeUnit.Day -> if (quantity == 1L) "dag" else "dagen"
            HumanTimeUnit.Week -> if (quantity == 1L) "week" else "weken"
            HumanTimeUnit.Month -> if (quantity == 1L) "maand" else "maanden"
            HumanTimeUnit.Year -> if (quantity == 1L) "jaar" else "jaren"
        }
    }
}