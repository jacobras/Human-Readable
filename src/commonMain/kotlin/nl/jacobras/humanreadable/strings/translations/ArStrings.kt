package nl.jacobras.humanreadable.strings.translations

import nl.jacobras.humanreadable.i18n.arabicPlural
import nl.jacobras.humanreadable.i18n.tenseForms
import nl.jacobras.humanreadable.strings.DateTimeStrings
import nl.jacobras.humanreadable.strings.DistanceStrings
import nl.jacobras.humanreadable.strings.FileSizeStrings
import nl.jacobras.humanreadable.strings.HumanReadableStrings

/** Builds an Arabic unit: singular/dual/few forms plus the accusative dual used in relative time. */
private fun arUnit(singular: String, dual: String, few: String, dualAccusative: String) = tenseForms {
    present(
        zero = singular,
        one = singular,
        two = dual,
        few = few,
        many = singular,
        other = singular
    )
    pastOrFuture(two = dualAccusative)
}

internal val ArStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
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
        now = "الآن"
    ),
    fileSize = FileSizeStrings(
        byteSymbol = "ب",
        kilobyteSymbol = "ك.ب",
        megabyteSymbol = "م.ب",
        gigabyteSymbol = "ج.ب",
        terabyteSymbol = "ت.ب"
    ),
    distance = DistanceStrings(
        meterAbbreviation = "م",
        kilometerAbbreviation = "كم",
        feetAbbreviation = "قدم",
        mileAbbreviation = "ميل"
    )
)