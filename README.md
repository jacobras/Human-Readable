# HumanReadable

![Android](http://img.shields.io/badge/-android-6EDB8D.svg?style=flat)
![JS](http://img.shields.io/badge/-js-F8DB5D.svg?style=flat)

A small set of data formatting utilities for Kotlin Multiplatform (KMP).

This library only supports [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime).

## Installation

The library is published to Maven Central.

```kotlin
dependencies {
    implementation("nl.jacobras:human-readable:1.1.0")
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

The library does a lookup to find the closest match. Unknown language codes will default to English.

```kotlin
HumanReadable.timeAgo(instant) // "3 days ago"

HumanReadable.setLocale("nl-NL")
HumanReadable.timeAgo(instant) // "3 dagen geleden"

HumanReadable.setLocale("fr")
HumanReadable.timeAgo(instant) // "il y a 3 jours"
```

### Getting the user's locale

* On Android using Context: `context.resources.configuration.locale.toLanguageTag()`
* On Android in Compose: `LocalConfiguration.current.locale.toLanguageTag`
* In Javascript: `window.navigator.language`

### Supported languages

* Dutch
* English (**default**)
* French
* German
* Italian
* Russian
* Spanish
* Turkish