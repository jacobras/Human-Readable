package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val ElStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = presentTense(one = "δευτερόλεπτο", other = "δευτερόλεπτα"),
        minutesLong = presentTense(one = "λεπτό", other = "λεπτά"),
        hoursLong = presentTense(one = "ώρα", other = "ώρες"),
        daysLong = presentTense(one = "μέρα", other = "μέρες"),
        weeksLong = presentTense(one = "εβδομάδα", other = "εβδομάδες"),
        monthsLong = multipleTenses {
            present(one = "μήνας", other = "μήνες")
            pastOrFuture(one = "μήνα")
        },
        yearsLong = presentTense(one = "έτος", other = "έτη"),
        timeAgo = { "$it πριν" },
        timeInFuture = { "σε $it" },
        now = "τώρα",
        today = "σήμερα",
        yesterday = "χθες",
        tomorrow = "αύριο"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)