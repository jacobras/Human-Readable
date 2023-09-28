package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object SpanishLocale : HumanLocale {
    override val code = "es"

    override val timeAgo: String
        get() = "hace %time%"
    override val timeInFuture: String
        get() = "en %time%"
    override val now: String
        get() = "ahora"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "segundo" else "segundos"
            HumanTimeUnit.Minute -> if (quantity == 1L) "minuto" else "minutos"
            HumanTimeUnit.Hour -> if (quantity == 1L) "hora" else "horas"
            HumanTimeUnit.Day -> if (quantity == 1L) "día" else "días"
            HumanTimeUnit.Week -> if (quantity == 1L) "semana" else "semanas"
            HumanTimeUnit.Month -> if (quantity == 1L) "mes" else "meses"
            HumanTimeUnit.Year -> if (quantity == 1L) "año" else "años"
        }
    }
}