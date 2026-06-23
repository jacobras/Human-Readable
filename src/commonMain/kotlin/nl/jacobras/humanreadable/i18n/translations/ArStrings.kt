package nl.jacobras.humanreadable.i18n.translations

import nl.jacobras.humanreadable.i18n.Plural
import nl.jacobras.humanreadable.i18n.multipleTenses
import nl.jacobras.humanreadable.i18n.DateTimeStrings
import nl.jacobras.humanreadable.i18n.DistanceStrings
import nl.jacobras.humanreadable.i18n.FileSizeStrings
import nl.jacobras.humanreadable.i18n.HumanReadableStrings

internal val ArStrings = HumanReadableStrings(
    dateTime = DateTimeStrings(
        plural = { count ->
            when {
                count == 0 -> Plural.Zero
                count == 1 -> Plural.One
                count == 2 -> Plural.Two
                count % 100 in 3..10 -> Plural.Few
                count % 100 in 11..99 -> Plural.Many
                else -> Plural.Other
            }
        },
        seconds = multipleTenses {
            present(zero = "ثانية", one = "ثانية", two = "ثانيتان", few = "ثوان", many = "ثانية", other = "ثانية")
            pastOrFuture(two = "ثانيتين")
        },
        minutes = multipleTenses {
            present(zero = "دقيقة", one = "دقيقة", two = "دقيقتان", few = "دقائق", many = "دقيقة", other = "دقيقة")
            pastOrFuture(two = "دقيقتين")
        },
        hours = multipleTenses {
            present(zero = "ساعة", one = "ساعة", two = "ساعتان", few = "ساعات", many = "ساعة", other = "ساعة")
            pastOrFuture(two = "ساعتين")
        },
        days = multipleTenses {
            present(zero = "يوم", one = "يوم", two = "يومان", few = "أيام", many = "يوم", other = "يوم")
            pastOrFuture(two = "يومين")
        },
        weeks = multipleTenses {
            present(zero = "أسبوع", one = "أسبوع", two = "أسبوعان", few = "أسابيع", many = "أسبوع", other = "أسبوع")
            pastOrFuture(two = "أسبوعين")
        },
        months = multipleTenses {
            present(zero = "شهر", one = "شهر", two = "شهران", few = "أشهر", many = "شهر", other = "شهر")
            pastOrFuture(two = "شهرين")
        },
        years = multipleTenses {
            present(zero = "سنة", one = "سنة", two = "سنتان", few = "سنوات", many = "سنة", other = "سنة")
            pastOrFuture(two = "سنتين")
        },
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