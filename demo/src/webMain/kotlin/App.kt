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
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import feature.AbbreviationDemo
import feature.DistanceDemo
import feature.FileSizeDemo
import feature.NumberFormatDemo
import feature.TimeDemo
import kotlinx.coroutines.launch
import nl.jacobras.humanreadable.HumanReadable
import ui.FeaturesList
import ui.FlexibleLayout
import ui.LanguageChip

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalMaterial3AdaptiveApi::class)
@Composable
internal fun App() {
    var selectedLanguageCode by remember { mutableStateOf(HumanReadable.languageTag) }
    var selectedFeature by remember { mutableStateOf(Feature.Time) }
    val layoutDirection = if (selectedLanguageCode == "ar") {
        LayoutDirection.Rtl
    } else {
        LayoutDirection.Ltr
    }

    fun onSelectLanguage(code: String) {
        selectedLanguageCode = code
        HumanReadable.languageTag = code
    }

    val navigator = rememberListDetailPaneScaffoldNavigator()
    val scope = rememberCoroutineScope()

    MaterialTheme {
        CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
            val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

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
                                append("HumanReadable.languageTag = \"")
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

                        ListDetailPaneScaffold(
                            directive = navigator.scaffoldDirective,
                            value = navigator.scaffoldValue,
                            listPane = {
                                FeaturesList(
                                    selected = selectedFeature,
                                    onSelect = {
                                        selectedFeature = it
                                        scope.launch {
                                            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                                        }
                                    }
                                )
                            },
                            detailPane = {
                                when (selectedFeature) {
                                    Feature.Time -> TimeDemo(selectedLanguageCode)
                                    Feature.File -> FileSizeDemo(selectedLanguageCode)
                                    Feature.Abbreviation -> AbbreviationDemo(selectedLanguageCode)
                                    Feature.Number -> NumberFormatDemo(selectedLanguageCode)
                                    Feature.Distance -> DistanceDemo(selectedLanguageCode)
                                }
                            },
                            paneExpansionDragHandle = { _ -> VerticalDivider() }
                        )

//                        FlexibleLayout(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .verticalScroll(rememberScrollState())
//                                .padding(bottom = 32.dp),
//                            timeDemo = { ,
//                            fileSizeDemo = {  },
//                            abbreviationDemo = { AbbreviationDemo(selectedLanguageCode, it) },
//                            numberFormatDemo = { NumberFormatDemo(selectedLanguageCode, it) },
//                            distanceDemo = { DistanceDemo(selectedLanguageCode, it) }
//                        )
                    }
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