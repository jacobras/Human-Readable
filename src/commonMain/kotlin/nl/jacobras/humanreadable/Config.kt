package nl.jacobras.humanreadable

import nl.jacobras.humanreadable.HumanReadable.localisation
import nl.jacobras.humanreadable.time.FormatStyle
import nl.jacobras.humanreadable.time.PartsConfig
import nl.jacobras.humanreadable.time.Rounding
import nl.jacobras.humanreadable.time.TimeUnit

public class Config {
    /**
     * The language tag (e.g. `"en"`, `"fr"`) to use when formatting. Defaults to the detected system
     * language when it is supported, otherwise [fallbackLanguageTag].
     */
    public var languageTag: String
        get() = localisation.languageTag
        set(value) {
            localisation.requestedLanguageTag = value
        }

    /**
     * The fallback language tag (e.g. `"en"`, `"fr"`) to use when [languageTag] is not supported.
     * If an unsupported language is passed in, nothing changes.
     *
     * Defaults to English.
     */
    public var fallbackLanguageTag: String
        get() = localisation.fallbackLanguageTag
        set(value) {
            localisation.fallbackLanguageTag = value
        }

    /**
     * Holds default parameters for time formatting of `duration()` and `timeAgo()`.
     */
    public var time: Time = Time()
        internal set
}

/**
 * Default parameters for time formatting of `duration()` and `timeAgo()`.
 */
public class Time {
    public var formatting: FormatStyle = FormatStyle()
    public var parts: PartsConfig = PartsConfig()
    public var units: Set<TimeUnit> = TimeUnit.all
    public var rounding: Rounding = Rounding.HalfUp
}