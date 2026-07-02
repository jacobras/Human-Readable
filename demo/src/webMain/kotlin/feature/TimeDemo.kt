package feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
import monoBodyOrange
import nl.jacobras.humanreadable.HumanReadable
import nl.jacobras.humanreadable.time.FormatStyle
import nl.jacobras.humanreadable.time.PartsConfig
import nl.jacobras.humanreadable.time.Rounding
import nl.jacobras.humanreadable.time.TimeUnit
import ui.CodeExample
import ui.appendKotlinCode
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalLayoutApi::class, ExperimentalTime::class)
@Composable
internal fun TimeDemo(
    selectedLanguageCode: String,
    modifier: Modifier = Modifier
) {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)
    val baseInstant = remember { Clock.System.now() }
    var myInstant by remember { mutableStateOf(baseInstant.minus(90, DateTimeUnit.SECOND)) }

    Column(modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
        Text(
            text = "Date/Time formatting",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(monoBodyOrange) { append("val ") }
                    append("baseInstant =")
                },
                style = monoBody
            )
            DateTimeField(baseInstant) {}
        }
        Spacer(Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(monoBodyOrange) { append("val ") }
                    append("myInstant =")
                },
                style = monoBody
            )
            DateTimeField(myInstant) { myInstant = it }
        }
        Spacer(Modifier.height(4.dp))

        FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Button(onClick = { myInstant = baseInstant }) { Text("[NOW]") }
            Button(onClick = { myInstant = myInstant.minus(10.seconds) }) { Text("-10 sec") }
            Button(onClick = { myInstant = myInstant.minus(1.minutes) }) { Text("-1 min") }
            Button(onClick = { myInstant = myInstant.minus(1.hours) }) { Text("-1 hr") }
            Button(onClick = { myInstant = myInstant.minus(1.days) }) { Text("-1 day") }
            Button(onClick = { myInstant = myInstant.minus(1.days) }) { Text("-7 days") }
            Button(onClick = { myInstant = myInstant.minus(30.days) }) { Text("-30 days") }
            Button(onClick = { myInstant = myInstant.minus(365.days) }) { Text("-365 days") }
        }
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "HumanReadable.duration(now - myInstant)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.duration(baseInstant - myInstant)
            }
        )
        Spacer(Modifier.height(12.dp))

        CodeExample(
            code = "HumanReadable.timeAgo(myInstant)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(myInstant)
            }
        )
        Spacer(Modifier.height(12.dp))

        CodeExample(
            code = "HumanReadable.timeAgo(myLocalDate) // overloaded method that takes a LocalDate",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    date = myInstant.toLocalDateTime(TimeZone.currentSystemDefault()).date,
                    baseDate = baseInstant.toLocalDateTime(TimeZone.currentSystemDefault()).date
                )
            }
        )
        Spacer(Modifier.height(32.dp))

        Text(
            text = "Configuration parameters",
            style = MaterialTheme.typography.titleLarge
        )
        Text(buildAnnotatedString {
            append("The examples below call ")
            appendKotlinCode("HumanReadable.timeAgo(option1, option2, ...)")
            append(". All parameters are optional and also work with ")
            appendKotlinCode("HumanReadable.duration()")
            append(".")
        })
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "formatting = FormatStyle(date = Date.Short)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    formatting = FormatStyle(date = FormatStyle.Date.Short)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "formatting = FormatStyle(date = Date.Narrow)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    formatting = FormatStyle(date = FormatStyle.Date.Narrow)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "formatting = FormatStyle(time = FormatStyle.Time.Digital)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    formatting = FormatStyle(time = FormatStyle.Time.Digital)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "formatting = FormatStyle(indicateApproximation = true)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    formatting = FormatStyle(indicateApproximation = true)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "rounding = Rounding.Floor",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    rounding = Rounding.Floor
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "rounding = Rounding.UpIfClose",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    rounding = Rounding.UpIfClose
                )
            },
            inline = true
        )
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "parts = PartsConfig(max = 3)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    parts = PartsConfig(max = 3)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "parts = PartsConfig(max = 3, subpartCutOffs = mapOf(TimeUnit.Minutes to 10, TimeUnit.Hours to 12))",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    parts = PartsConfig(
                        max = 3,
                        subpartCutOffs = mapOf(TimeUnit.Minutes to 10, TimeUnit.Hours to 12)
                    )
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "parts = PartsConfig(smallestDuration = 10.minutes)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    parts = PartsConfig(smallestDuration = 10.minutes)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "units = setOf(TimeUnit.Hours, TimeUnit.Days)",
            res = remember(selectedLanguageCode, baseInstant, myInstant) {
                HumanReadable.timeAgo(
                    myInstant, baseInstant,
                    units = setOf(TimeUnit.Hours, TimeUnit.Days)
                )
            },
            inline = true
        )
        Spacer(Modifier.height(8.dp))
    }
}

@OptIn(ExperimentalTime::class)
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