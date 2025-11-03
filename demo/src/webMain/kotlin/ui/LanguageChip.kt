package ui

import Language
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun LanguageChip(
    language: Language,
    selected: Boolean,
    onClick: () -> Unit,
    smallDisplay: Boolean
) {
    val label = if (smallDisplay) {
        language.code
    } else {
        "${language.name} (\"${language.code}\")"
    }

    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) }
    )
}