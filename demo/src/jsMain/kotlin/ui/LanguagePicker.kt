package ui

import Language
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LanguagePicker(
    selectedLanguageCode: String,
    onSelectLanguage: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val availableLanguages = remember { Language.entries }
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
