package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.FileSizeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings

internal val FiStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = multipleTenses {
            present(one = "sekunti", other = "sekuntia")
            future(one = "sekunnin", other = "sekunnin")
        },
        minutesLong = multipleTenses {
            present(one = "minuutti", other = "minuuttia")
            future(one = "minuutin", other = "minuutin")
        },
        hoursLong = multipleTenses {
            present(one = "tunti", other = "tuntia")
            future(one = "tunnin", other = "tunnin")
        },
        daysLong = multipleTenses {
            present(one = "päivä", other = "päivää")
            future(one = "päivän", other = "päivän")
        },
        weeksLong = multipleTenses {
            present(one = "viikko", other = "viikkoa")
            future(one = "viikon", other = "viikon")
        },
        monthsLong = multipleTenses {
            present(one = "kuukausi", other = "kuukautta")
            future(one = "kuukauden", other = "kuukauden")
        },
        yearsLong = multipleTenses {
            present(one = "vuosi", other = "vuotta")
            future(one = "vuoden", other = "vuoden")
        },
        timeAgo = { "$it sitten" },
        timeInFuture = { "$it kuluttua" },
        now = "nyt",
        today = "tänään",
        yesterday = "eilen",
        tomorrow = "huomenna"
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