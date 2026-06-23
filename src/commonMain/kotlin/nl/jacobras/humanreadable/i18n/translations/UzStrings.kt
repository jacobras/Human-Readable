package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings
import nl.jacobras.humanreadable.i18n.NumberStrings
import nl.jacobras.humanreadable.i18n.multipleTenses

internal val UzStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = multipleTenses {
            present(one = "soniya", other = "soniya")
            future(one = "soniyadan", other = "soniyadan")
        },
        minutes = multipleTenses {
            present(one = "daqiqa", other = "daqiqa")
            future(one = "daqiqadan", other = "daqiqadan")
        },
        hours = multipleTenses {
            present(one = "soat", other = "soat")
            future(one = "soatdan", other = "soatdan")
        },
        days = multipleTenses {
            present(one = "kun", other = "kun")
            future(one = "kundan", other = "kundan")
        },
        weeks = multipleTenses {
            present(one = "hafta", other = "hafta")
            future(one = "haftadan", other = "haftadan")
        },
        months = multipleTenses {
            present(one = "oy", other = "oy")
            future(one = "oydan", other = "oydan")
        },
        years = multipleTenses {
            present(one = "yil", other = "yil")
            future(one = "yildan", other = "yildan")
        },
        timeAgo = { "$it oldin" },
        timeInFuture = { "$it keyin" },
        now = "hozir"
    ),
    number = NumberStrings(groupSeparator = ".", decimalSymbol = ",")
)