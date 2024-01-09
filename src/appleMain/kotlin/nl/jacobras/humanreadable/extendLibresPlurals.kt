package nl.jacobras.humanreadable

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
}