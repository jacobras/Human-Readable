# HumanReadable

A small set of data formatting utilities for Kotlin Multiplatform (KMP). The library isn't localised yet, but will be.

### 🕰️ Relative time

```kotlin
HumanReadable.timeAgo(now - 4.hours) // "4 hours ago"
HumanReadable.timeAgo(now + 8.minutes) // "in 8 minutes"
```

### ⏱️ Duration

```kotlin
* HumanReadable.duration(23.days) // "23 days"
* HumanReadable.duration(5.seconds) // "5 seconds"
```

### 📂 File size

File size formatting uses base 1024.

```kotlin
* HumanReadable.fileSize(333) // "333 B"
* HumanReadable.fileSize(2_048, decimals = 1) // "2.0 kB"
* HumanReadable.fileSize(20_411_000_000, decimals = 2) // "20.44 GB"
```