# HumanReadable

![Android](http://img.shields.io/badge/-android-6EDB8D.svg?style=flat)
![iOS](http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat)
![tvOS](http://img.shields.io/badge/-tvos-808080.svg?style=flat)
![watchOS](http://img.shields.io/badge/-watchos-D32D41.svg?style=flat)
![JS](http://img.shields.io/badge/-js-F8DB5D.svg?style=flat)
![wasm](https://img.shields.io/badge/-wasm-624DE9.svg?style=flat)

A small set of data formatting utilities for Kotlin Multiplatform (KMP).

This library only supports [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime).

## Installation

The library is published to Maven Central.

**Note:** HumanReadable 1.12+ requires kotlinx-datetime 0.7+, see https://github.com/jacobras/Human-Readable/issues/148.

```kotlin
dependencies {
    implementation("nl.jacobras:Human-Readable:2.0.0") // Not yet published!
}
```

## Features

An interactive demo is available at https://jacobras.github.io/Human-Readable/.

### 🕰️ Relative time

```kotlin
HumanReadable.timeAgo(now - 134.minutes) // "2 hours ago"
HumanReadable.timeAgo(now + 8.minutes) // "in 8 minutes"
```

### ⏱️ Duration

```kotlin
HumanReadable.duration(5.seconds) // "5 seconds"
HumanReadable.duration(7.days) // "1 week"
HumanReadable.duration(544.hours) // "3 weeks"
```

### ✍️ Formatting options

The formatter switches to a bigger unit (minute, hour, day, ...) as soon as it can.

There are a number of configuration options available for both `timeAgo()` and `duration()`.

```kotlin
HumanReadable.timeAgo(
    instant = now - 134.minutes,
    formatting = FormatStyle(
        date = FormatStyle.Date.Long, // or Short: "1 hr, 50 min" or Narrow: "1h 50m"
        time = FormatStyle.Time.Regular, // or Digital: "01:50:00"
        indicateApproximation = true // will prefix "about" if the formatted time is not exact (i.e. a part was dropped or rounded)
    ),
    parts = PartsConfig(
        max = 2, // "1 hour, 50 minutes"
        smallestDuration = 10.minutes, // anything smaller will return "less than 10 minutes"
        subpartCutOffs = mapOf(TimeUnit.Hours to 12.hours) // drops subparts, e.g. "11 hours, 40 minutes" and then "12 hours"
    ),
    units = setOf(TimeUnit.Hours), // limits the output to these units, e.g. "391 days"
    rounding = Rounding.HalfUp // or Floor to round down, or UpIfClose to round up on 55 seconds/55 minutes/23 hours/13 days
)
```

// TODO: global configuration

Visit the [interactive demo](#features) to see more examples in action.

### 📂 File size

File size formatting uses base 1024.

```kotlin
HumanReadable.fileSize(333) // "333 B"
HumanReadable.fileSize(2_048, decimals = 1) // "2.0 kB"
HumanReadable.fileSize(21_947_282_882, decimals = 2) // "20.44 GB" in English / "20.44 Go" in French
```

### 🔢 Number abbreviation

Available since version 1.8, localised since 1.10.

```kotlin
HumanReadable.abbreviation(3_000) // "3K"
HumanReadable.abbreviation(500_000) // "500K"
HumanReadable.abbreviation(2_500_000, decimals = 1) // "2.5M"
```

### 🔢 Number formatting

Available since version 1.10.

```kotlin
// English
HumanReadable.number(1_000_000.34) // "1,000,000.34"

// French
HumanReadable.number(1_000_000.34) // "1 000 000.34"

// Dutch
HumanReadable.number(1_000_000.34) // "1.000.000,34"
```

### ↔️ Distance

Available since version 1.11.

```kotlin
// Metric examples
HumanReadable.distance(value = 956, unit = DistanceUnit.Meter) // "956 m"
HumanReadable.distance(value = 1534, unit = DistanceUnit.Meter) // "1.5 km"
HumanReadable.distance(value = 5400, unit = DistanceUnit.Meter, decimals = 2) // "5.40 km"

// Imperial examples
HumanReadable.distance(value = 5200, unit = DistanceUnit.Foot) // "5,200 ft"
HumanReadable.distance(value = 5350, unit = DistanceUnit.Foot) // "1.0 mi"
HumanReadable.distance(value = 28512, unit = DistanceUnit.Foot, decimals = 2) // "5.40 mi"
```

**Note:** numbers in meters and feet are always formatted with zero decimals. The passed in
number of decimals is only used for the larger units kilometers and miles.

## Localisation

The library uses an internal i18n mechanism. It detects the current locale by default, but it's changeable at
runtime via `HumanReadable.languageTag`:

```kotlin
HumanReadable.timeAgo(instant) // "3 days ago"

HumanReadable.languageTag = "nl"
HumanReadable.timeAgo(instant) // "3 dagen geleden"

HumanReadable.languageTag = "fr"
HumanReadable.timeAgo(instant) // "il y a 3 jours"
```

If the requested locale is not supported, the library will fall back to `HumanReadable.fallbackLanguageTag`, which by
default is set to English.

### Supported languages

* Arabic (since 1.13.0)
* Czech
* Chinese (since 1.3.0)
* Dutch
* **English**
* Finnish (since 1.7.0)
* French
* German
* Greek (since 1.11.0)
* Italian
* Indonesian
* Japanese (since 1.5.0)
* Kazakh (since 1.10.0)
* Korean (since 1.5.0)
* Polish (since 1.3.0)
* Portuguese (since 1.9.0)
* Russian
* Spanish
* Turkish
* Ukrainian
* Uzbek (since 1.4.0)
* Vietnamese (since 1.6.0)

#### Adding a language

Missing a language? Feel free to open an issue about it. Or, add it yourself:

1. Fork the code and navigate to `src/commonMain/kotlin/nl/jacobras/humanreadable/i18n/translations`
2. Add a file named `XxStrings.kt` (where `Xx` is
   the [language code](https://www.unicode.org/cldr/charts/48/supplemental/language_plural_rules.html)). Follow the
   example of other translations.
3. Add a new entry to the `translations` map in
   `src/commonMain/kotlin/nl/jacobras/humanreadable/i18n/translations.kt`.
4. Open a PR.

Follow the Unicode spec at <https://st.unicode.org/cldr-apps/v#/en/Duration/>
or <https://github.com/unicode-org/cldr-json/blob/main/cldr-json/cldr-units-full/main/en/units.json>, if you prefer the
JSON format.