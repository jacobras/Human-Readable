package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object ItalianLocale : HumanLocale {
    override val code = "it"

    override val timeAgo: String
        get() = "%time% fa"
    override val timeInFuture: String
        get() = "tra %time%"
    override val now: String
        get() = "adesso"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "secondo" else "secondi"
            HumanTimeUnit.Minute -> if (quantity == 1L) "minuto" else "minuti"
            HumanTimeUnit.Hour -> if (quantity == 1L) "ora" else "ore"
            HumanTimeUnit.Day -> if (quantity == 1L) "giorno" else "giorni"
            HumanTimeUnit.Week -> if (quantity == 1L) "settimana" else "settimane"
            HumanTimeUnit.Month -> if (quantity == 1L) "mese" else "mesi"
            HumanTimeUnit.Year -> if (quantity == 1L) "anno" else "anni"
        }
    }
}