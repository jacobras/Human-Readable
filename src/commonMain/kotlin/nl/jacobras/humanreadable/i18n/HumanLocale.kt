package nl.jacobras.humanreadable.i18n

interface HumanLocale {

    /**
     * IEFC code.
     */
    val code: String

    val timeAgo: String
        get() = "%time% ago"
    val timeInFuture: String
        get() = "in %time%"
    val now: String
        get() = "now"

    fun format(unit: HumanTimeUnit, quantity: Long): String {
        return when (unit) {
            HumanTimeUnit.Second -> if (quantity == 1L) "second" else "seconds"
            HumanTimeUnit.Minute -> if (quantity == 1L) "minute" else "minutes"
            HumanTimeUnit.Hour -> if (quantity == 1L) "hour" else "hours"
            HumanTimeUnit.Day -> if (quantity == 1L) "day" else "days"
            HumanTimeUnit.Week -> if (quantity == 1L) "week" else "weeks"
            HumanTimeUnit.Month -> if (quantity == 1L) "month" else "months"
            HumanTimeUnit.Year -> if (quantity == 1L) "year" else "years"
        }
    }
}

enum class HumanTimeUnit {
    Second, Minute, Hour, Day, Week, Month, Year
}