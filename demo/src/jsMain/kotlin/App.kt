import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun App() {
    var selectedLanguageCode by remember { mutableStateOf(LibresSettings.languageCode ?: "en") }

    fun onSelectLanguage(code: String) {
        selectedLanguageCode = code
        LibresSettings.languageCode = code
    }

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
                    .padding(horizontal = 32.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Language:")
                    Spacer(Modifier.width(8.dp))
                    LanguagePicker(
                        selectedLanguageCode = selectedLanguageCode,
                        onSelectLanguage = ::onSelectLanguage
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                val now = remember { Clock.System.now() }
                val instant1 = remember { mutableStateOf(now.minus(133, DateTimeUnit.HOUR)) }
                val instant2 = remember { mutableStateOf(now.plus(2, DateTimeUnit.HOUR)) }

                val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)
                val monoBodyOrange = SpanStyle(
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFFca5c22),
                    fontWeight = FontWeight.Medium
                )
                val monoBodyString = SpanStyle(
                    fontFamily = FontFamily.Monospace,
                    color = Color(0xFF6aab73)
                )

                Text(
                    text = "Date/Time",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text("Change the dates below to see the values update live.")
                Spacer(Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(monoBodyOrange) { append("val ") }
                            append("instant1 = ")
                        },
                        style = monoBody
                    )
                    DateTimeField(instant1)
                }
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(monoBodyOrange) { append("val ") }
                            append("instant2 = ")
                        },
                        style = monoBody
                    )
                    DateTimeField(instant2)
                }
                Spacer(Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        append("HumanReadable.timeAgo(instant1) = ")
                        withStyle(monoBodyString) {
                            append("\"")
                            append(HumanReadable.timeAgo(instant1.value))
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
                            append(HumanReadable.timeAgo(instant2.value))
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
                            append(HumanReadable.duration(instant2.value - instant1.value))
                            append("\"")
                        }
                    },
                    style = monoBody
                )
                Spacer(Modifier.height(32.dp))

                Text(
                    text = "File size",
                    style = MaterialTheme.typography.headlineLarge
                )
                val f1 = HumanReadable.fileSize(21_947_282_882, decimals = 2)
                Text(
                    text = buildAnnotatedString {
                        append("HumanReadable.fileSize(21_947_282_882, decimals = 2): ")
                        withStyle(monoBodyString) {
                            append("\"")
                            append(f1)
                            append("\"")
                        }
                    },
                    style = monoBody
                )
            }
        }
    }
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
            value = availableLanguages.first { it.code == selectedLanguageCode }.name,
            onValueChange = { },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
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
private fun DateTimeField(instant: MutableState<Instant>) {
    var error by remember { mutableStateOf(false) }
    var value by remember { mutableStateOf(instant.value.toString()) }

    TextField(
        modifier = Modifier.widthIn(min = 0.dp),
        value = value,
        onValueChange = {
            value = it
            try {
                instant.value = Instant.parse(it)
                error = false
            } catch (e: IllegalArgumentException) {
                error = true
            }
        },
        isError = error
    )
}