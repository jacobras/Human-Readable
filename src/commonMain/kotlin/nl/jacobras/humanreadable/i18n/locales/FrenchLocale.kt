package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object FrenchLocale : HumanLocale {
    override val code = "fr"

    override val timeAgo: String
        get() = "il y a %time%"
    override val timeInFuture: String
        get() = "dans %time%"
    override val now: String
        get() = "maintenant"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "seconde" else "secondes"
            HumanTimeUnit.Minute -> if (quantity == 1L) "minute" else "minutes"
            HumanTimeUnit.Hour -> if (quantity == 1L) "heure" else "heures"
            HumanTimeUnit.Day -> if (quantity == 1L) "jour" else "jours"
            HumanTimeUnit.Week -> if (quantity == 1L) "semaine" else "semaines"
            HumanTimeUnit.Month -> if (quantity == 1L) "mois" else "mois"
            HumanTimeUnit.Year -> if (quantity == 1L) "an" else "ans"
        }
    }
}