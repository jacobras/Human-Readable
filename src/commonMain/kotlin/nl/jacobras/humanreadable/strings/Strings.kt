package nl.jacobras.humanreadable.strings

import nl.jacobras.humanreadable.i18n.Localization
import nl.jacobras.humanreadable.strings.translations.ArStrings
import nl.jacobras.humanreadable.strings.translations.CsStrings
import nl.jacobras.humanreadable.strings.translations.DeStrings
import nl.jacobras.humanreadable.strings.translations.ElStrings
import nl.jacobras.humanreadable.strings.translations.EnStrings
import nl.jacobras.humanreadable.strings.translations.EsStrings
import nl.jacobras.humanreadable.strings.translations.FiStrings
import nl.jacobras.humanreadable.strings.translations.FrStrings
import nl.jacobras.humanreadable.strings.translations.IdStrings
import nl.jacobras.humanreadable.strings.translations.ItStrings
import nl.jacobras.humanreadable.strings.translations.JaStrings
import nl.jacobras.humanreadable.strings.translations.KkStrings
import nl.jacobras.humanreadable.strings.translations.KoStrings
import nl.jacobras.humanreadable.strings.translations.NlStrings
import nl.jacobras.humanreadable.strings.translations.PlStrings
import nl.jacobras.humanreadable.strings.translations.PtStrings
import nl.jacobras.humanreadable.strings.translations.RuStrings
import nl.jacobras.humanreadable.strings.translations.TrStrings
import nl.jacobras.humanreadable.strings.translations.UkStrings
import nl.jacobras.humanreadable.strings.translations.UzStrings
import nl.jacobras.humanreadable.strings.translations.ViStrings
import nl.jacobras.humanreadable.strings.translations.ZhStrings

private val translations: Map<String, HumanReadableStrings> = mapOf(
    "ar" to ArStrings,
    "cs" to CsStrings,
    "de" to DeStrings,
    "el" to ElStrings,
    "en" to EnStrings,
    "es" to EsStrings,
    "fi" to FiStrings,
    "fr" to FrStrings,
    "id" to IdStrings,
    "it" to ItStrings,
    "ja" to JaStrings,
    "kk" to KkStrings,
    "ko" to KoStrings,
    "nl" to NlStrings,
    "pl" to PlStrings,
    "pt" to PtStrings,
    "ru" to RuStrings,
    "tr" to TrStrings,
    "uk" to UkStrings,
    "uz" to UzStrings,
    "vi" to ViStrings,
    "zh" to ZhStrings
)

/**
 * The single source of localized strings. Defaults to English and, like the previous setup, adopts
 * the detected system language when it is supported, falling back to English otherwise. The active
 * language can be changed at runtime via [nl.jacobras.humanreadable.HumanReadable.languageTag].
 */
internal val localization = Localization(translations, fallback = EnStrings)

/** The currently active set of strings. */
internal val strings: HumanReadableStrings
    get() = localization.current