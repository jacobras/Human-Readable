package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.frenchPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.FileSizeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val FrStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::frenchPlural,
        seconds = presentTense(one = "seconde", other = "secondes"),
        minutes = presentTense(one = "minute", other = "minutes"),
        hours = presentTense(one = "heure", other = "heures"),
        days = presentTense(one = "jour", other = "jours"),
        weeks = presentTense(one = "semaine", other = "semaines"),
        months = presentTense(one = "mois", other = "mois"),
        years = presentTense(one = "an", other = "ans"),
        timeAgo = { "il y a $it" },
        timeInFuture = { "dans $it" },
        now = "maintenant"
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