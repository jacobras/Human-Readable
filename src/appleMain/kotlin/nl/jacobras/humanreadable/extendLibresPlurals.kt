package nl.jacobras.humanreadable

import io.github.skeptick.libres.strings.PluralForm
import io.github.skeptick.libres.strings.PluralRule
import io.github.skeptick.libres.strings.PluralRules

// See also: jsMain
actual fun extendLibresPlurals() {
    // Make all Libres plurals default to the English implementation
    // Workaround until https://github.com/Skeptick/libres/issues/53 is fixed
    PluralRules["nl"] = PluralRules["en"]
    PluralRules["de"] = PluralRules["en"]
    PluralRules["es"] = PluralRules["en"]
    PluralRules["it"] = PluralRules["en"]
    PluralRules["tr"] = PluralRules["en"]

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["cs"] = PluralRule { number ->
        when (number) {
            1 -> PluralForm.One
            in (2..4) -> PluralForm.Few
            else -> PluralForm.Other
        }
    }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["id"] = PluralRule { PluralForm.Other }
}