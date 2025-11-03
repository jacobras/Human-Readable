import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.LibresSettings
import ui.AbbreviationDemo
import ui.DistanceDemo
import ui.FileSizeDemo
import ui.FlexibleLayout
import ui.LanguageChip
import ui.NumberFormatDemo
import ui.TimeDemo

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
                    .padding(horizontal = 32.dp)
            ) {
                val smallDisplay = maxWidth < 800.dp
                Column(
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("LibresSettings.languageCode = \"")
                            withStyle(monoBodyStringBold) {
                                append(selectedLanguageCode)
                            }
                            append("\"")
                        },
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
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 32.dp),
                        timeDemo = { TimeDemo(selectedLanguageCode, it) },
                        fileSizeDemo = { FileSizeDemo(selectedLanguageCode, it) },
                        abbreviationDemo = { AbbreviationDemo(selectedLanguageCode, it) },
                        numberFormatDemo = { NumberFormatDemo(selectedLanguageCode, it) },
                        distanceDemo = { DistanceDemo(selectedLanguageCode, it) }
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
internal val monoBodyStringBold = monoBodyString.copy(
    fontWeight = FontWeight.Bold
)