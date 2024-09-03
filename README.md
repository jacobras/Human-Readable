# HumanReadable

![Android](http://img.shields.io/badge/-android-6EDB8D.svg?style=flat)
![iOS](http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat)
![JS](http://img.shields.io/badge/-js-F8DB5D.svg?style=flat)
![wasm](https://img.shields.io/badge/-wasm-624DE9.svg?style=flat)

A small set of data formatting utilities for Kotlin Multiplatform (KMP).

This library only supports [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime).

## Installation

The library is published to Maven Central.

```kotlin
dependencies {
    implementation("nl.jacobras:Human-Readable:1.10.0")
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

**Note**: The formatter switches to a bigger unit (minute, hour, day, ...) as soon as it can. See [Precision](#datetime-precision).

### 📂 File size

File size formatting uses base 1024.

```kotlin
HumanReadable.fileSize(333) // "333 B"
HumanReadable.fileSize(2_048, decimals = 1) // "2.0 kB"
HumanReadable.fileSize(21_947_282_882, decimals = 2) // "20.44 GB" in English / "20.44 Go" in French
```

### 🔢 Number abbreviation

Available since version 1.8, localized since 1.10.

```kotlin
HumanReadable.abbreviation(3_000) // "3K"
HumanReadable.abbreviation(500_000) // "500K"
HumanReadable.abbreviation(2_500_000, decimals = 1) // "2.5M"
```

### 🔢 Number formatting

Available since version 1.10.

```kotlin
// English/default
HumanReadable.number(1_000_000.34) // "1,000,000.34"

// French
HumanReadable.number(1_000_000.34) // "1 000 000.34"

// Dutch
HumanReadable.number(1_000_000.34) // "1.000.000,34"
```

## Date/time precision
The formatter switches to a bigger unit (minute, hour, day, ...) as soon as it can.
For example:

* `59.seconds` is "59 seconds" but `60.seconds` becomes "1 minute"
* `6.days` is "6 days" but `7.days` becomes "1 week"
* `29.days` is "29 days" but `30.days` becomes "1 month"

There's also some rounding involved:

* `8.days` and `10.days` are "1 week", but `11.days` already becomes "2 weeks"

This behaviour may become configurable in future releases.

## Localisation

The library uses the small [Libres](https://github.com/Skeptick/libres) library for its string resources. It detects the
current locale by default, but it's changeable on runtime.
See [Libres: Changing Localization](https://github.com/Skeptick/libres/blob/master/docs/LOCALIZATION.md#changing-localization).

You don't need to manually import Libres, as Gradle already pulls it in along with HumanReadable.

```kotlin
HumanReadable.timeAgo(instant) // "3 days ago"

LibresSettings.languageCode = "nl"
HumanReadable.timeAgo(instant) // "3 dagen geleden"

LibresSettings.languageCode = "fr"
HumanReadable.timeAgo(instant) // "il y a 3 jours"
```

### Supported languages

* Czech
* Chinese (since 1.3.0)
* Dutch
* English (**default**)
* Finnish (since 1.7.0)
* French
* German
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

1. Fork the code and navigate to [src/commonMain/libres/strings/](https://github.com/jacobras/Human-Readable/tree/main/src/commonMain/libres/strings)
2. Add a file named `time_units_[LANGUAGE CODE].xml` (see [Unicode: CLDR chart](https://www.unicode.org/cldr/charts/42/supplemental/language_plural_rules.html) for the code & plural categories).
3. If the language deviates from English data units (like French does), also add `data_units_[LANGUAGE CODE].xml`.
4. Open a PR.