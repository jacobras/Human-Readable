package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.FileSizeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val FiStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = presentTense(one = "sekunti", other = "sekuntia"),
        minutes = presentTense(one = "minuutti", other = "minuuttia"),
        hours = presentTense(one = "tunti", other = "tuntia"),
        days = presentTense(one = "päivä", other = "päivää"),
        weeks = presentTense(one = "viikko", other = "viikkoa"),
        months = presentTense(one = "kuukausi", other = "kuukautta"),
        years = presentTense(one = "vuosi", other = "vuotta"),
        timeAgo = { "$it sitten" },
        timeInFuture = { "$it tulevaisuudessa" },
        now = "nyt"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ","),
    fileSize = FileSizeStrings(
        byteSymbol = "t",
        kilobyteSymbol = "kt",
        megabyteSymbol = "Mt",
        gigabyteSymbol = "Gt",
        terabyteSymbol = "Tt"
    )
)