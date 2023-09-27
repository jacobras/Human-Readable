package nl.jacobras.humanreadable.i18n.locales

import nl.jacobras.humanreadable.i18n.HumanLocale
import nl.jacobras.humanreadable.i18n.HumanTimeUnit

internal object RussianLocale : HumanLocale {
    override val code = "ru"

    override val timeAgo: String
        get() = "%time% назад"
    override val timeInFuture: String
        get() = "через %time%"
    override val now: String
        get() = "сейчас"

    override fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "секунда"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "секунды"
                    else -> "секунд"
                }
            }
            HumanTimeUnit.Minute -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "минута"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "минуты"
                    else -> "минут"
                }
            }
            HumanTimeUnit.Hour -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "час"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "часа"
                    else -> "часов"
                }
            }
            HumanTimeUnit.Day -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "день"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "дня"
                    else -> "дней"
                }
            }
            HumanTimeUnit.Week -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "неделя"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "недели"
                    else -> "недель"
                }
            }
            HumanTimeUnit.Month -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "месяц"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "месяца"
                    else -> "месяцев"
                }
            }
            HumanTimeUnit.Year -> {
                when {
                    quantity % 10 == 1L && quantity != 11L -> "год"
                    (quantity % 10 == 2L || quantity % 10 == 3L || quantity % 10 == 4L) &&
                        (quantity % 100 < 10 || quantity % 100 > 20) -> "года"
                    else -> "лет"
                }
            }
        }
    }
}