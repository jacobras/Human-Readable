package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.FileSizeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val FrStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 0 || count == 1) Plural.One else Plural.Other },
        secondsLong = presentTense(one = "seconde", other = "secondes"),
        minutesLong = presentTense(one = "minute", other = "minutes"),
        hoursLong = presentTense(one = "heure", other = "heures"),
        daysLong = presentTense(one = "jour", other = "jours"),
        weeksLong = presentTense(one = "semaine", other = "semaines"),
        monthsLong = presentTense(one = "mois", other = "mois"),
        yearsLong = presentTense(one = "an", other = "ans"),
        secondsShort = presentTense(one = "s"),
        minutesShort = presentTense(one = "min"),
        hoursShort = presentTense(one = "h"),
        daysShort = presentTense(one = "j"),
        weeksShort = presentTense(one = "sem."),
        monthsShort = presentTense(one = "m."),
        yearsShort = presentTense(one = "an"),
        secondsNarrow = presentTense(one = "s"),
        minutesNarrow = presentTense(one = "min"),
        hoursNarrow = presentTense(one = "h"),
        daysNarrow = presentTense(one = "j"),
        weeksNarrow = presentTense(one = "sem."),
        monthsNarrow = presentTense(one = "m."),
        yearsNarrow = presentTense(one = "an"),
        timeAgo = { "il y a $it" },
        timeInFuture = { "dans $it" },
        now = "maintenant",
        today = "aujourd'hui",
        yesterday = "hier",
        tomorrow = "demain",
        lessThan = "moins de",
        about = "environ"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ","),
    fileSize = FileSizeStrings(
        byteSymbol = "o",
        kilobyteSymbol = "ko",
        megabyteSymbol = "Mo",
        gigabyteSymbol = "Go",
        terabyteSymbol = "To"
    )
)