package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object GermanLocale : HumanLocale {
    override val code = "de"

    override val timeAgo: String
        get() = "vor %time%"
    override val timeInFuture: String
        get() = "in %time%"
    override val now: String
        get() = "jetzt"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "Sekunde" else "Sekunden"
            HumanTimeUnit.Minute -> if (quantity == 1L) "Minute" else "Minuten"
            HumanTimeUnit.Hour -> if (quantity == 1L) "Stunde" else "Stunden"
            HumanTimeUnit.Day -> if (quantity == 1L) "Tag" else "Tage"
            HumanTimeUnit.Week -> if (quantity == 1L) "Woche" else "Wochen"
            HumanTimeUnit.Month -> if (quantity == 1L) "Monat" else "Monate"
            HumanTimeUnit.Year -> if (quantity == 1L) "Jahr" else "Jahre"
        }
    }
}