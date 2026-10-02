package nl.jacobras.humanreadable.i18n

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString
import platform.posix.getenv

@OptIn(ExperimentalForeignApi::class)
internal actual fun systemLanguageTag(): String {
    val envValue = getenv("LANGUAGE")?.toKString()?.substringBefore(':')
        ?: getenv("LC_ALL")?.toKString()
        ?: getenv("LANG")?.toKString()
    return envValue
        ?.substringBefore('.') // Remove charset: "en_US.UTF-8" » "en_US"
        ?.substringBefore('@') // Remove modifier: "sr_RS@latin" » "sr_RS"
        ?.takeIf {
            // Apparently some distros may return "C" or "POSIX" if there is no locale data
            it.isNotBlank() && !it.equals("C", true) && !it.equals("POSIX", true)
        }
        ?.replace('_', '-') ?: "en"
}