package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object TurkishLocale : HumanLocale {
    override val code = "tr"

    override val timeAgo: String
        get() = "%time% önce"
    override val timeInFuture: String
        get() = "%time% sonra"
    override val now: String
        get() = "şimdi"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "saniye" else "saniye"
            HumanTimeUnit.Minute -> if (quantity == 1L) "dakika" else "dakika"
            HumanTimeUnit.Hour -> if (quantity == 1L) "saat" else "saat"
            HumanTimeUnit.Day -> if (quantity == 1L) "gün" else "gün"
            HumanTimeUnit.Week -> if (quantity == 1L) "hafta" else "hafta"
            HumanTimeUnit.Month -> if (quantity == 1L) "ay" else "ay"
            HumanTimeUnit.Year -> if (quantity == 1L) "yıl" else "yıl"
        }
    }
}