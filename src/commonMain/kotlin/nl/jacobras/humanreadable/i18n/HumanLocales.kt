package nl.jacobras.humanreadable.i18n

import nl.jacobras.humanreadable.i18n.locales.DutchLocale
import nl.jacobras.humanreadable.i18n.locales.EnglishLocale
import nl.jacobras.humanreadable.i18n.locales.FrenchLocale
import nl.jacobras.humanreadable.i18n.locales.GermanLocale
import nl.jacobras.humanreadable.i18n.locales.ItalianLocale
import nl.jacobras.humanreadable.i18n.locales.RussianLocale
import nl.jacobras.humanreadable.i18n.locales.SpanishLocale
import nl.jacobras.humanreadable.i18n.locales.TurkishLocale

@Suppress("unused", "MemberVisibilityCanBePrivate")
enum class HumanLocales(val locale: HumanLocale) {
    Default(EnglishLocale),

    Dutch(DutchLocale),
    English(EnglishLocale),
    French(FrenchLocale),
    German(GermanLocale),
    Italian(ItalianLocale),
    Russian(RussianLocale),
    Spanish(SpanishLocale),
    Turkish(TurkishLocale),
}