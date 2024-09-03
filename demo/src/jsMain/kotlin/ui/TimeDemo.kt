package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.datetime.*
import monoBodyOrange
import monoBodyString
import nl.jacobras.humanreadable.HumanReadable
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours

@Composable
internal fun TimeDemo(selectedLanguageCode: String) {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)
    val now = remember { Clock.System.now() }
    var instant1 by remember { mutableStateOf(now.minus(1337, DateTimeUnit.HOUR)) }
    var instant2 by remember { mutableStateOf(now.plus(2, DateTimeUnit.HOUR)) }

    Text(
        text = "Date/Time",
        style = MaterialTheme.typography.headlineLarge
    )
    Text("Change the dates below to see the values update live.")
    Spacer(Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("instant1 =")
            },
            style = monoBody
        )
        DateTimeField(instant1) { instant1 = it }
    }
    Spacer(Modifier.height(8.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("instant2 =")
            },
            style = monoBody
        )
        DateTimeField(instant2) { instant2 = it }
        Button(onClick = { instant2 = instant2.plus(1.hours) }) { Text("+ hour") }
        Button(onClick = { instant2 = instant2.plus(1.days) }) { Text("+ day") }
        Button(onClick = { instant2 = instant2.plus(30.days) }) { Text("+ ~month") }
        Button(onClick = { instant2 = instant2.plus(365.days) }) { Text("+ ~year") }
    }
    Spacer(Modifier.height(16.dp))

    Text(
        text = buildAnnotatedString {
            append("HumanReadable.timeAgo(instant1) = ")
            withStyle(monoBodyString) {
                append("\"")
                append(remember(selectedLanguageCode, instant1) { HumanReadable.timeAgo(instant1) })
                append("\"")
            }
        },
        style = monoBody
    )
    Text(
        text = buildAnnotatedString {
            append("HumanReadable.timeAgo(instant2) = ")
            withStyle(monoBodyString) {
                append("\"")
                append(remember(selectedLanguageCode, instant2) { HumanReadable.timeAgo(instant2) })
                append("\"")
            }
        },
        style = monoBody
    )
    Spacer(Modifier.height(16.dp))

    Text(
        text = buildAnnotatedString {
            append("HumanReadable.duration(instant2 - instant1) = ")
            withStyle(monoBodyString) {
                append("\"")
                append(remember(selectedLanguageCode, instant1, instant2) {
                    HumanReadable.duration(instant2 - instant1)
                })
                append("\"")
            }
        },
        style = monoBody
    )
}

@Composable
private fun DateTimeField(instant: Instant, onUpdate: (Instant) -> Unit) {
    var error by remember { mutableStateOf(false) }
    var value by remember(instant) { mutableStateOf(instant.toString()) }

    TextField(
        modifier = Modifier.widthIn(min = 0.dp),
        value = value,
        onValueChange = {
            value = it
            try {
                onUpdate(Instant.parse(it))
                error = false
            } catch (e: IllegalArgumentException) {
                error = true
            }
        },
        isError = error,
        supportingText = if (error) {
            { Text("Invalid date format. Please use ISO-8601 ;-)") }
        } else null
    )
}