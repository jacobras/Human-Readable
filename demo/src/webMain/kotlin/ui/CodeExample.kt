package ui

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily

@Composable
internal fun CodeExample(code: String, res: String, inline: Boolean = false) {
    SelectionContainer {
        val separator = if (inline) " " else "\n"
        Text(
            text = buildAnnotatedString { appendKotlinCode("$code$separator// \"$res\"") },
            style = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)
        )
    }
}