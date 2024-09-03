import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.LibresSettings
import ui.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
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
                TopAppBar(title = { Text("Human-Readable web demo") })
            }
        ) { paddingValues ->
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(horizontal = 32.dp).padding(bottom = 32.dp)
            ) {
                val smallDisplay = maxWidth < 600.dp
                Column(
                ) {
                    Text(
                        text = "LibresSettings.languageCode = \"$selectedLanguageCode\"",
                        style = monoBody
                    )
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        val sortedLanguages = Language.entries
                            .sortedBy { it.code }
                            .sortedByDescending { it == Language.English }
                        for (language in sortedLanguages) {
                            LanguageChip(
                                language = language,
                                selected = language.code == selectedLanguageCode,
                                onClick = { onSelectLanguage(language.code) },
                                smallDisplay = smallDisplay
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))

                    FlexibleLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        timeDemo = { TimeDemo(selectedLanguageCode, it) },
                        fileSizeDemo = { FileSizeDemo(selectedLanguageCode, it) },
                        abbreviationDemo = { AbbreviationDemo(selectedLanguageCode, it) },
                        numberFormatDemo = { NumberFormatDemo(selectedLanguageCode, it) }
                    )
                }
            }
        }
    }
}

internal val monoBodyOrange = SpanStyle(
    fontFamily = FontFamily.Monospace,
    color = Color(0xFFca5c22),
    fontWeight = FontWeight.Medium
)
internal val monoBodyString = SpanStyle(
    fontFamily = FontFamily.Monospace,
    color = Color(0xFF6aab73)
)