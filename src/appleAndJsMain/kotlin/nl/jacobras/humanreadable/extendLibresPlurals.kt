package nl.jacobras.humanreadable

import io.github.skeptick.libres.strings.PluralForm
import io.github.skeptick.libres.strings.PluralRule
import io.github.skeptick.libres.strings.PluralRules

/**
 * Only used by Apple & JS.
 */
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

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["pl"] = PluralRule { number ->
        when {
            number == 1 -> PluralForm.One
            (number % 10) in 2..4 && (number % 100) !in 12..14 -> PluralForm.Few
            else -> PluralForm.Many
        }
    }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["zh"] = PluralRule { PluralForm.Other }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["uz"] = PluralRule { number ->
        when (number) {
            1 -> PluralForm.One
            else -> PluralForm.Other
        }
    }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["ja"] = PluralRule { PluralForm.Other }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["ko"] = PluralRule { PluralForm.Other }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["vi"] = PluralRule { PluralForm.Other }

    // TODO: Remove when https://github.com/Skeptick/libres/pull/56 is merged
    PluralRules["fi"] = PluralRule { number ->
        when (number) {
            1 -> PluralForm.One
            else -> PluralForm.Other
        }
    }
}