package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.defaultPlural
import nl.jacobras.humanreadable.i18n.tenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings

/** Builds a Kazakh unit (singular/plural identical) with its future (ablative) form. */
private fun kkUnit(word: String, future: String) = tenseForms {
    present(one = word, other = word)
    future(one = future, other = future)
}

internal val KkStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::defaultPlural,
        seconds = kkUnit("секунд", "секундтан"),
        minutes = kkUnit("минут", "минуттан"),
        hours = kkUnit("сағат", "сағаттан"),
        days = kkUnit("күн", "күннен"),
        weeks = kkUnit("апта", "аптадан"),
        months = kkUnit("ай", "айдан"),
        years = kkUnit("жыл", "жылдан"),
        timeAgo = { "$it бұрын" },
        timeInFuture = { "$it кейін" },
        now = "қазір"
    )
)