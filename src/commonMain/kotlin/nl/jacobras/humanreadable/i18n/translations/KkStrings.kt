package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val KkStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        secondsLong = multipleTenses {
            present(one = "секунд", other = "секунд")
            future(one = "секундтан", other = "секундтан")
        },
        minutesLong = multipleTenses {
            present(one = "минут", other = "минут")
            future(one = "минуттан", other = "минуттан")
        },
        hoursLong = multipleTenses {
            present(one = "сағат", other = "сағат")
            future(one = "сағаттан", other = "сағаттан")
        },
        daysLong = multipleTenses { present(one = "күн", other = "күн"); future(one = "күннен", other = "күннен") },
        weeksLong = multipleTenses { present(one = "апта", other = "апта"); future(one = "аптадан", other = "аптадан") },
        monthsLong = multipleTenses { present(one = "ай", other = "ай"); future(one = "айдан", other = "айдан") },
        yearsLong = multipleTenses { present(one = "жыл", other = "жыл"); future(one = "жылдан", other = "жылдан") },
        timeAgo = { "$it бұрын" },
        timeInFuture = { "$it кейін" },
        now = "қазір",
        today = "бүгін",
        yesterday = "кеше",
        tomorrow = "ертең"
    )
)