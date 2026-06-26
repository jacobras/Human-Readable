package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val KkStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count -> if (count == 1) Plural.One else Plural.Other },
        seconds = multipleTenses {
            present(one = "секунд", other = "секунд")
            future(one = "секундтан", other = "секундтан")
        },
        minutes = multipleTenses {
            present(one = "минут", other = "минут")
            future(one = "минуттан", other = "минуттан")
        },
        hours = multipleTenses {
            present(one = "сағат", other = "сағат")
            future(one = "сағаттан", other = "сағаттан")
        },
        days = multipleTenses { present(one = "күн", other = "күн"); future(one = "күннен", other = "күннен") },
        weeks = multipleTenses { present(one = "апта", other = "апта"); future(one = "аптадан", other = "аптадан") },
        months = multipleTenses { present(one = "ай", other = "ай"); future(one = "айдан", other = "айдан") },
        years = multipleTenses { present(one = "жыл", other = "жыл"); future(one = "жылдан", other = "жылдан") },
        timeAgo = { "$it бұрын" },
        timeInFuture = { "$it кейін" },
        now = "қазір",
        today = "бүгін",
        yesterday = "кеше",
        tomorrow = "ертең"
    )
)