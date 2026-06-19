package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.presentTense
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.FileSizeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val FiStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
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