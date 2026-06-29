package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings
import nl.jacobras.humanreadable.i18n.multipleTenses

internal val UzStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = multipleTenses {
            present(one = "soniya", other = "soniya")
            future(one = "soniyadan", other = "soniyadan")
        },
        minutesLong = multipleTenses {
            present(one = "daqiqa", other = "daqiqa")
            future(one = "daqiqadan", other = "daqiqadan")
        },
        hoursLong = multipleTenses {
            present(one = "soat", other = "soat")
            future(one = "soatdan", other = "soatdan")
        },
        daysLong = multipleTenses {
            present(one = "kun", other = "kun")
            future(one = "kundan", other = "kundan")
        },
        weeksLong = multipleTenses {
            present(one = "hafta", other = "hafta")
            future(one = "haftadan", other = "haftadan")
        },
        monthsLong = multipleTenses {
            present(one = "oy", other = "oy")
            future(one = "oydan", other = "oydan")
        },
        yearsLong = multipleTenses {
            present(one = "yil", other = "yil")
            future(one = "yildan", other = "yildan")
        },
        timeAgo = { "$it oldin" },
        timeInFuture = { "$it keyin" },
        now = "hozir",
        today = "bugun",
        yesterday = "kecha",
        tomorrow = "ertaga"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)