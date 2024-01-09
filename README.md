# HumanReadable

![Android](http://img.shields.io/badge/-android-6EDB8D.svg?style=flat)
![iOS](http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat)
![JS](http://img.shields.io/badge/-js-F8DB5D.svg?style=flat)

A small set of data formatting utilities for Kotlin Multiplatform (KMP).

This library only supports [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime).

## Installation

The library is published to Maven Central.

```kotlin
dependencies {
    implementation("nl.jacobras:human-readable:1.2.0")
}
```

## Features

### 🕰️ Relative time

```kotlin
HumanReadable.timeAgo(now - 134.minutes) // "2 hours ago"
HumanReadable.timeAgo(now + 8.minutes) // "in 8 minutes"
```

### ⏱️ Duration

```kotlin
HumanReadable.duration(7.days) // "1 week"
HumanReadable.duration(544.hours) // "23 days"
HumanReadable.duration(5.seconds) // "5 seconds"
```

### 📂 File size

File size formatting uses base 1024.

```kotlin
HumanReadable.fileSize(333) // "333 B"
HumanReadable.fileSize(2_048, decimals = 1) // "2.0 kB"
HumanReadable.fileSize(20_411_000_000, decimals = 2) // "20.44 GB"
```

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

* Dutch
* English (**default**)
* French
* German
* Italian
* Indonesian
* Russian
* Spanish
* Turkish