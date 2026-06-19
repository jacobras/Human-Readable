package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.czechPlural
import nl.jacobras.humanreadable.i18n.tenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings
import nl.jacobras.humanreadable.strings.NumberStrings

internal val CsStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = ::czechPlural,
        seconds = tenseForms {
            present(one = "sekunda", few = "sekundy", other = "sekund")
            past(one = "sekundou", few = "sekundami", other = "sekundami")
            future(one = "sekundu", few = "sekundy", other = "sekund")
        },
        minutes = tenseForms {
            present(one = "minuta", few = "minuty", other = "minut")
            past(one = "minutou", few = "minutami", other = "minutami")
            future(one = "minutu", few = "minuty", other = "minut")
        },
        hours = tenseForms {
            present(one = "hodina", few = "hodiny", other = "hodin")
            past(one = "hodinou", few = "hodinami", other = "hodinami")
            future(one = "hodinu", few = "hodiny", other = "hodin")
        },
        days = tenseForms {
            present(one = "den", few = "dny", other = "dní")
            past(one = "dnem", few = "dny", other = "dny")
        },
        weeks = tenseForms {
            present(one = "týden", few = "týdny", other = "týdnů")
            past(one = "týdnem", few = "týdny", other = "týdny")
        },
        months = tenseForms {
            present(one = "měsíc", few = "měsíce", other = "měsíců")
            past(one = "měsícem", few = "měsíci", other = "měsíci")
        },
        years = tenseForms {
            present(one = "rok", few = "roky", other = "let")
            past(one = "rokem", few = "roky", other = "lety")
        },
        timeAgo = { "před $it" },
        timeInFuture = { "za $it" },
        now = "nyní"
    ),
    number = NumberStrings(groupSeparator = " ", decimalSymbol = ",")
)