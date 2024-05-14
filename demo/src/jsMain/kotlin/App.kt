import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.LibresSettings
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import nl.jacobras.humanreadable.HumanReadable
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun App() {
    var selectedLanguageCode by remember { mutableStateOf(LibresSettings.languageCode ?: "en") }

    fun onSelectLanguage(code: String) {
        selectedLanguageCode = code
        LibresSettings.languageCode = code
    }

    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Human-Readable web demo") }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier.padding(padding)
                    .padding(horizontal = 32.dp).padding(bottom = 32.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "LibresSettings.languageCode = ",
                        style = monoBody
                    )
                    LanguagePicker(
                        selectedLanguageCode = selectedLanguageCode,
                        onSelectLanguage = ::onSelectLanguage
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                TimeDemo()
                Spacer(Modifier.height(32.dp))

                FileSizeDemo()
                Spacer(Modifier.height(32.dp))

                AbbreviationDemo()
            }
        }
    }
}

@Composable
private fun TimeDemo() {
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
                append(HumanReadable.timeAgo(instant1))
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
                append(HumanReadable.timeAgo(instant2))
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
                append(HumanReadable.duration(instant2 - instant1))
                append("\"")
            }
        },
        style = monoBody
    )
}

@Composable
private fun FileSizeDemo() {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

    Text(
        text = "File size",
        style = MaterialTheme.typography.headlineLarge
    )
    Text("File size formatting uses base 1024.")
    Spacer(Modifier.height(16.dp))
    var myFile by remember { mutableStateOf("21947") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("myFile = ")
            },
            style = monoBody
        )
        TextField(
            modifier = Modifier.sizeIn(minWidth = 20.dp),
            value = myFile,
            onValueChange = {
                if (it.length < 16) {
                    myFile = it
                }
            }
        )
        Text(
            text = " bytes",
            style = monoBody
        )
    }
    Spacer(Modifier.height(8.dp))
    var decimals by remember { mutableStateOf("2") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("decimals = ")
            },
            style = monoBody
        )
        TextField(
            modifier = Modifier.sizeIn(minWidth = 20.dp),
            value = decimals,
            onValueChange = {
                val updatedDecimals = it.toIntOrNull()
                if (updatedDecimals != null && updatedDecimals < 10) {
                    decimals = it
                }
            }
        )
    }
    Spacer(Modifier.height(8.dp))
    Text(
        text = buildAnnotatedString {
            append("HumanReadable.fileSize(myFile, decimals) = ")
            withStyle(monoBodyString) {
                append("\"")
                append(
                    HumanReadable.fileSize(
                        bytes = myFile.toLongOrNull() ?: 0L,
                        decimals = decimals.toIntOrNull() ?: 0
                    )
                )
                append("\"")
            }
        },
        style = monoBody
    )
}

@Composable
private fun AbbreviationDemo() {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

    Text(
        text = "Abbreviation",
        style = MaterialTheme.typography.headlineLarge
    )
    Spacer(Modifier.height(16.dp))
    var myNumber by remember { mutableStateOf("3000") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("myNumber = ")
            },
            style = monoBody
        )
        TextField(
            modifier = Modifier.sizeIn(minWidth = 20.dp),
            value = myNumber,
            onValueChange = {
                if (it.length < 16) {
                    myNumber = it
                }
            }
        )
    }
    Spacer(Modifier.height(8.dp))
    var decimals by remember { mutableStateOf("2") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("decimals = ")
            },
            style = monoBody
        )
        TextField(
            modifier = Modifier.sizeIn(minWidth = 20.dp),
            value = decimals,
            onValueChange = {
                val updatedDecimals = it.toIntOrNull()
                if (updatedDecimals != null && updatedDecimals < 10) {
                    decimals = it
                }
            }
        )
    }
    Spacer(Modifier.height(8.dp))
    Text(
        text = buildAnnotatedString {
            append("HumanReadable.abbreviation(myNumber, decimals) = ")
            withStyle(monoBodyString) {
                append("\"")
                append(
                    HumanReadable.abbreviation(
                        number = myNumber.toLongOrNull() ?: 0L,
                        decimals = decimals.toIntOrNull() ?: 0
                    )
                )
                append("\"")
            }
        },
        style = monoBody
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LanguagePicker(
    selectedLanguageCode: String,
    onSelectLanguage: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val availableLanguages = remember { Languages.entries }
    ExposedDropdownMenuBox(
        modifier = Modifier.clickable { expanded = true },
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = "\"" + availableLanguages.first { it.code == selectedLanguageCode }.code + "\"",
            onValueChange = { },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace,
                color = Color(0xFF6aab73)
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (language in availableLanguages) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = language.name,
                            fontWeight = if (selectedLanguageCode == language.code) {
                                FontWeight.Bold
                            } else {
                                FontWeight.Normal
                            }
                        )

                    },
                    onClick = {
                        onSelectLanguage(language.code)
                        expanded = false
                    }
                )
            }
        }
    }
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
        isError = error
    )
}

private val monoBodyOrange = SpanStyle(
    fontFamily = FontFamily.Monospace,
    color = Color(0xFFca5c22),
    fontWeight = FontWeight.Medium
)
private val monoBodyString = SpanStyle(
    fontFamily = FontFamily.Monospace,
    color = Color(0xFF6aab73)
)