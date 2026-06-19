package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val ElStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = presentTense(one = "δευτερόλεπτο", other = "δευτερόλεπτα"),
        minutes = presentTense(one = "λεπτό", other = "λεπτά"),
        hours = presentTense(one = "ώρα", other = "ώρες"),
        days = presentTense(one = "μέρα", other = "μέρες"),
        weeks = presentTense(one = "εβδομάδα", other = "εβδομάδες"),
        months = presentTense(one = "μήνα", other = "μήνες"),
        years = presentTense(one = "έτος", other = "έτη"),
        timeAgo = { "$it πριν" },
        timeInFuture = { "σε $it" },
        now = "τώρα"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)