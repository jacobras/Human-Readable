package nl.jacobras.humanreadable.strings

import cafe.adriel.lyricist.LanguageTag
import cafe.adriel.lyricist.Lyricist
import cafe.adriel.lyricist.LyricistStrings

/**
 * English is the canonical, fully-populated set of strings. Every other language is built with
 * `copy()` and only overrides what differs from English (matching the previous resource fallback:
 * languages without their own number/data/distance strings reuse the English ones).
 */
internal val EnStrings = HumanReadableStrings(
    plural = ::defaultPlural,
    seconds = oneOther("second", "seconds"),
    minutes = oneOther("minute", "minutes"),
    hours = oneOther("hour", "hours"),
    days = oneOther("day", "days"),
    weeks = oneOther("week", "weeks"),
    months = oneOther("month", "months"),
    years = oneOther("year", "years"),
    timeAgo = { "$it ago" },
    timeInFuture = { "in $it" },
    now = "now"
)

/** Builds an Arabic unit: singular/dual/few forms plus the accusative dual used in relative time. */
private fun arUnit(singular: String, dual: String, few: String, dualAccusative: String) = TenseForms(
    present = mapOf(
        Plural.Zero to singular,
        Plural.One to singular,
        Plural.Two to dual,
        Plural.Few to few,
        Plural.Many to singular,
        Plural.Other to singular
    ),
    past = mapOf(Plural.Two to dualAccusative),
    future = mapOf(Plural.Two to dualAccusative)
)

@LyricistStrings(languageTag = "en-US")
private val ArStrings = EnStrings.copy(
    plural = ::arabicPlural,
    seconds = arUnit("ثانية", "ثانيتان", "ثوان", "ثانيتين"),
    minutes = arUnit("دقيقة", "دقيقتان", "دقائق", "دقيقتين"),
    hours = arUnit("ساعة", "ساعتان", "ساعات", "ساعتين"),
    days = arUnit("يوم", "يومان", "أيام", "يومين"),
    weeks = arUnit("أسبوع", "أسبوعان", "أسابيع", "أسبوعين"),
    months = arUnit("شهر", "شهران", "أشهر", "شهرين"),
    years = arUnit("سنة", "سنتان", "سنوات", "سنتين"),
    timeAgo = { "قبل $it" },
    timeInFuture = { "بعد $it" },
    now = "الآن",
    byteSymbol = "ب",
    kilobyteSymbol = "ك.ب",
    megabyteSymbol = "م.ب",
    gigabyteSymbol = "ج.ب",
    terabyteSymbol = "ت.ب",
    meterAbbreviation = "م",
    kilometerAbbreviation = "كم",
    feetAbbreviation = "قدم",
    mileAbbreviation = "ميل"
)

private val CsStrings = EnStrings.copy(
    plural = ::czechPlural,
    seconds = TenseForms(
        present = mapOf(Plural.One to "sekunda", Plural.Few to "sekundy", Plural.Other to "sekund"),
        past = mapOf(Plural.One to "sekundou", Plural.Few to "sekundami", Plural.Other to "sekundami"),
        future = mapOf(Plural.One to "sekundu", Plural.Few to "sekundy", Plural.Other to "sekund")
    ),
    minutes = TenseForms(
        present = mapOf(Plural.One to "minuta", Plural.Few to "minuty", Plural.Other to "minut"),
        past = mapOf(Plural.One to "minutou", Plural.Few to "minutami", Plural.Other to "minutami"),
        future = mapOf(Plural.One to "minutu", Plural.Few to "minuty", Plural.Other to "minut")
    ),
    hours = TenseForms(
        present = mapOf(Plural.One to "hodina", Plural.Few to "hodiny", Plural.Other to "hodin"),
        past = mapOf(Plural.One to "hodinou", Plural.Few to "hodinami", Plural.Other to "hodinami"),
        future = mapOf(Plural.One to "hodinu", Plural.Few to "hodiny", Plural.Other to "hodin")
    ),
    days = TenseForms(
        present = mapOf(Plural.One to "den", Plural.Few to "dny", Plural.Other to "dní"),
        past = mapOf(Plural.One to "dnem", Plural.Few to "dny", Plural.Other to "dny")
    ),
    weeks = TenseForms(
        present = mapOf(Plural.One to "týden", Plural.Few to "týdny", Plural.Other to "týdnů"),
        past = mapOf(Plural.One to "týdnem", Plural.Few to "týdny", Plural.Other to "týdny")
    ),
    months = TenseForms(
        present = mapOf(Plural.One to "měsíc", Plural.Few to "měsíce", Plural.Other to "měsíců"),
        past = mapOf(Plural.One to "měsícem", Plural.Few to "měsíci", Plural.Other to "měsíci")
    ),
    years = TenseForms(
        present = mapOf(Plural.One to "rok", Plural.Few to "roky", Plural.Other to "let"),
        past = mapOf(Plural.One to "rokem", Plural.Few to "roky", Plural.Other to "lety")
    ),
    timeAgo = { "před $it" },
    timeInFuture = { "za $it" },
    now = "nyní",
    groupSeparator = " ",
    decimalSymbol = ","
)

private val DeStrings = EnStrings.copy(
    seconds = oneOther("Sekunde", "Sekunden"),
    minutes = oneOther("Minute", "Minuten"),
    hours = oneOther("Stunde", "Stunden"),
    days = TenseForms(
        present = mapOf(Plural.One to "Tag", Plural.Other to "Tage"),
        past = mapOf(Plural.Other to "Tagen"),
        future = mapOf(Plural.Other to "Tagen")
    ),
    weeks = oneOther("Woche", "Wochen"),
    months = TenseForms(
        present = mapOf(Plural.One to "Monat", Plural.Other to "Monate"),
        past = mapOf(Plural.Other to "Monaten"),
        future = mapOf(Plural.Other to "Monaten")
    ),
    years = TenseForms(
        present = mapOf(Plural.One to "Jahr", Plural.Other to "Jahre"),
        past = mapOf(Plural.Other to "Jahren"),
        future = mapOf(Plural.Other to "Jahren")
    ),
    timeAgo = { "vor $it" },
    timeInFuture = { "in $it" },
    now = "jetzt",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val ElStrings = EnStrings.copy(
    seconds = oneOther("δευτερόλεπτο", "δευτερόλεπτα"),
    minutes = oneOther("λεπτό", "λεπτά"),
    hours = oneOther("ώρα", "ώρες"),
    days = oneOther("μέρα", "μέρες"),
    weeks = oneOther("εβδομάδα", "εβδομάδες"),
    months = oneOther("μήνα", "μήνες"),
    years = oneOther("έτος", "έτη"),
    timeAgo = { "$it πριν" },
    timeInFuture = { "σε $it" },
    now = "τώρα",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val EsStrings = EnStrings.copy(
    seconds = oneOther("segundo", "segundos"),
    minutes = oneOther("minuto", "minutos"),
    hours = oneOther("hora", "horas"),
    days = oneOther("día", "días"),
    weeks = oneOther("semana", "semanas"),
    months = oneOther("mes", "meses"),
    years = oneOther("año", "años"),
    timeAgo = { "hace $it" },
    timeInFuture = { "en $it" },
    now = "ahora",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val FiStrings = EnStrings.copy(
    seconds = oneOther("sekunti", "sekuntia"),
    minutes = oneOther("minuutti", "minuuttia"),
    hours = oneOther("tunti", "tuntia"),
    days = oneOther("päivä", "päivää"),
    weeks = oneOther("viikko", "viikkoa"),
    months = oneOther("kuukausi", "kuukautta"),
    years = oneOther("vuosi", "vuotta"),
    timeAgo = { "$it sitten" },
    timeInFuture = { "$it tulevaisuudessa" },
    now = "nyt",
    groupSeparator = " ",
    decimalSymbol = ",",
    byteSymbol = "t",
    kilobyteSymbol = "kt",
    megabyteSymbol = "Mt",
    gigabyteSymbol = "Gt",
    terabyteSymbol = "Tt"
)

private val FrStrings = EnStrings.copy(
    plural = ::frenchPlural,
    seconds = oneOther("seconde", "secondes"),
    minutes = oneOther("minute", "minutes"),
    hours = oneOther("heure", "heures"),
    days = oneOther("jour", "jours"),
    weeks = oneOther("semaine", "semaines"),
    months = oneOther("mois", "mois"),
    years = oneOther("an", "ans"),
    timeAgo = { "il y a $it" },
    timeInFuture = { "dans $it" },
    now = "maintenant",
    groupSeparator = " ",
    decimalSymbol = ",",
    byteSymbol = "o",
    kilobyteSymbol = "ko",
    megabyteSymbol = "Mo",
    gigabyteSymbol = "Go",
    terabyteSymbol = "To"
)

private val IdStrings = EnStrings.copy(
    plural = ::otherPlural,
    seconds = invariant("detik"),
    minutes = invariant("menit"),
    hours = invariant("jam"),
    days = invariant("hari"),
    weeks = invariant("minggu"),
    months = invariant("bulan"),
    years = invariant("tahun"),
    timeAgo = { "$it yang lalu" },
    timeInFuture = { "dalam $it" },
    now = "sekarang",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val ItStrings = EnStrings.copy(
    seconds = oneOther("secondo", "secondi"),
    minutes = oneOther("minuto", "minuti"),
    hours = oneOther("ora", "ore"),
    days = oneOther("giorno", "giorni"),
    weeks = oneOther("settimana", "settimane"),
    months = oneOther("mese", "mesi"),
    years = oneOther("anno", "anni"),
    timeAgo = { "$it fa" },
    timeInFuture = { "tra $it" },
    now = "adesso",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val JaStrings = EnStrings.copy(
    plural = ::otherPlural,
    seconds = invariant("秒"),
    minutes = invariant("分"),
    hours = invariant("時間"),
    days = invariant("日"),
    weeks = invariant("週"),
    months = invariant("ヶ月"),
    years = invariant("年"),
    timeAgo = { "${it}前" },
    timeInFuture = { "${it}後" },
    now = "今"
)

/** Builds a Kazakh unit (singular/plural identical) with its future (ablative) form. */
private fun kkUnit(word: String, future: String) = TenseForms(
    present = mapOf(Plural.One to word, Plural.Other to word),
    future = mapOf(Plural.One to future, Plural.Other to future)
)

private val KkStrings = EnStrings.copy(
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

private val KoStrings = EnStrings.copy(
    plural = ::otherPlural,
    seconds = invariant("초"),
    minutes = invariant("분"),
    hours = invariant("시"),
    days = invariant("일"),
    weeks = invariant("주"),
    months = invariant("월"),
    years = invariant("년"),
    timeAgo = { "$it 전" },
    timeInFuture = { "$it 후" },
    now = "지금"
)

private val NlStrings = EnStrings.copy(
    seconds = oneOther("seconde", "seconden"),
    minutes = oneOther("minuut", "minuten"),
    hours = oneOther("uur", "uur"),
    days = oneOther("dag", "dagen"),
    weeks = oneOther("week", "weken"),
    months = oneOther("maand", "maanden"),
    years = oneOther("jaar", "jaar"),
    timeAgo = { "$it geleden" },
    timeInFuture = { "over $it" },
    now = "nu",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val PlStrings = EnStrings.copy(
    plural = ::polishPlural,
    seconds = TenseForms(
        present = mapOf(Plural.One to "sekunda", Plural.Few to "sekundy", Plural.Many to "sekund"),
        past = mapOf(Plural.One to "sekundę"),
        future = mapOf(Plural.One to "sekundę")
    ),
    minutes = TenseForms(
        present = mapOf(Plural.One to "minuta", Plural.Few to "minuty", Plural.Many to "minut"),
        past = mapOf(Plural.One to "minutę"),
        future = mapOf(Plural.One to "minutę")
    ),
    hours = TenseForms(
        present = mapOf(Plural.One to "godzina", Plural.Few to "godziny", Plural.Many to "godzin"),
        past = mapOf(Plural.One to "godzinę"),
        future = mapOf(Plural.One to "godzinę")
    ),
    days = TenseForms(
        present = mapOf(Plural.One to "dzień", Plural.Few to "dni", Plural.Many to "dni")
    ),
    weeks = TenseForms(
        present = mapOf(Plural.One to "tydzień", Plural.Few to "tygodnie", Plural.Many to "tygodni")
    ),
    months = TenseForms(
        present = mapOf(Plural.One to "miesiąc", Plural.Few to "miesiące", Plural.Many to "miesięcy")
    ),
    years = TenseForms(
        present = mapOf(Plural.One to "rok", Plural.Few to "lata", Plural.Many to "lat")
    ),
    timeAgo = { "$it temu" },
    timeInFuture = { "za $it" },
    now = "teraz",
    groupSeparator = " ",
    decimalSymbol = ","
)

/** Builds a Portuguese unit (one / "de"-plural for millions / other). */
private fun ptUnit(one: String, many: String, other: String) = TenseForms(
    present = mapOf(Plural.One to one, Plural.Many to many, Plural.Other to other)
)

private val PtStrings = EnStrings.copy(
    plural = ::portuguesePlural,
    seconds = ptUnit("segundo", "de segundos", "segundos"),
    minutes = ptUnit("minuto", "de minutos", "minutos"),
    hours = ptUnit("hora", "de horas", "horas"),
    days = ptUnit("dia", "de dias", "dias"),
    weeks = ptUnit("semana", "de semanas", "semanas"),
    months = ptUnit("mês", "de meses", "meses"),
    years = ptUnit("ano", "de anos", "anos"),
    timeAgo = { "há $it" },
    timeInFuture = { "em $it" },
    now = "agora",
    groupSeparator = " ",
    decimalSymbol = ","
)

/** Builds a unit with only a present one/few/many form (Russian/Ukrainian). */
private fun slavicUnit(one: String, few: String, many: String) = TenseForms(
    present = mapOf(Plural.One to one, Plural.Few to few, Plural.Many to many)
)

private val RuStrings = EnStrings.copy(
    plural = ::eastSlavicPlural,
    seconds = TenseForms(
        present = mapOf(Plural.One to "секунда", Plural.Few to "секунды", Plural.Many to "секунд"),
        past = mapOf(Plural.One to "секунду"),
        future = mapOf(Plural.One to "секунду")
    ),
    minutes = TenseForms(
        present = mapOf(Plural.One to "минута", Plural.Few to "минуты", Plural.Many to "минут"),
        past = mapOf(Plural.One to "минуту"),
        future = mapOf(Plural.One to "минуту")
    ),
    hours = slavicUnit("час", "часа", "часов"),
    days = slavicUnit("день", "дня", "дней"),
    weeks = TenseForms(
        present = mapOf(Plural.One to "неделя", Plural.Few to "недели", Plural.Many to "недель"),
        past = mapOf(Plural.One to "неделю"),
        future = mapOf(Plural.One to "неделю")
    ),
    months = slavicUnit("месяц", "месяца", "месяцев"),
    years = slavicUnit("год", "года", "лет"),
    timeAgo = { "$it назад" },
    timeInFuture = { "через $it" },
    now = "сейчас",
    groupSeparator = " ",
    decimalSymbol = ","
)

private val TrStrings = EnStrings.copy(
    seconds = invariant("saniye"),
    minutes = invariant("dakika"),
    hours = invariant("saat"),
    days = invariant("gün"),
    weeks = invariant("hafta"),
    months = invariant("ay"),
    years = invariant("yıl"),
    timeAgo = { "$it önce" },
    timeInFuture = { "$it sonra" },
    now = "şimdi",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val UkStrings = EnStrings.copy(
    plural = ::eastSlavicPlural,
    seconds = slavicUnit("секунду", "секунди", "секунд"),
    minutes = slavicUnit("хвилину", "хвилини", "хвилин"),
    hours = slavicUnit("годину", "години", "годин"),
    days = slavicUnit("день", "дні", "днів"),
    weeks = slavicUnit("тиждень", "тижні", "тижнів"),
    months = slavicUnit("місяць", "місяці", "місяців"),
    years = slavicUnit("рік", "роки", "років"),
    timeAgo = { "$it тому" },
    timeInFuture = { "через $it" },
    now = "зараз",
    groupSeparator = " ",
    decimalSymbol = ","
)

private val UzStrings = EnStrings.copy(
    seconds = invariant("soniya"),
    minutes = invariant("daqiqa"),
    hours = invariant("soat"),
    days = invariant("kun"),
    weeks = invariant("hafta"),
    months = invariant("oy"),
    years = invariant("yil"),
    timeAgo = { "$it oldin" },
    timeInFuture = { "$it keyin" },
    now = "hozir",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val ViStrings = EnStrings.copy(
    plural = ::otherPlural,
    seconds = invariant("giây"),
    minutes = invariant("phút"),
    hours = invariant("giờ"),
    days = invariant("ngày"),
    weeks = invariant("tuần"),
    months = invariant("tháng"),
    years = invariant("năm"),
    timeAgo = { "$it trước" },
    timeInFuture = { "vào $it" },
    now = "bây giờ",
    groupSeparator = ".",
    decimalSymbol = ","
)

private val ZhStrings = EnStrings.copy(
    plural = ::otherPlural,
    seconds = invariant("秒"),
    minutes = invariant("分钟"),
    hours = invariant("小时"),
    days = invariant("天"),
    weeks = invariant("周"),
    months = invariant("个月"),
    years = invariant("年"),
    timeAgo = { "${it}之前" },
    timeInFuture = { "${it}之后" },
    now = "现在"
)

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
internal val lyricist: Lyricist<HumanReadableStrings> =
    Lyricist(defaultLanguageTag = "en", translations = translations).apply {
        val system = systemLanguageTag()
        if (translations.containsKey(system)) {
            languageTag = system
        }
    }

/** The currently active set of strings. */
internal val strings: HumanReadableStrings
    get() = lyricist.strings
