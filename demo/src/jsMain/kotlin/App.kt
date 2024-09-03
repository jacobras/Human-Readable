import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.LibresSettings
import ui.AbbreviationDemo
import ui.FileSizeDemo
import ui.LanguagePicker
import ui.TimeDemo

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
                TopAppBar(title = { Text("Human-Readable web demo") })
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
                    .padding(horizontal = 32.dp).padding(bottom = 32.dp)
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

                TimeDemo(selectedLanguageCode)
                Spacer(Modifier.height(32.dp))

                FileSizeDemo(selectedLanguageCode)
                Spacer(Modifier.height(32.dp))

                AbbreviationDemo(selectedLanguageCode)
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