package ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
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
import monoBodyOrange

@Composable
internal fun DecimalsInput(
    decimals: Int,
    onChange: (Int) -> Unit,
) {
    var input by remember { mutableStateOf(decimals.toString()) }
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)
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
            value = input,
            onValueChange = {
                input = it
                val new = it.toIntOrNull()
                if (new != null) {
                    onChange(new)
                }
            },
            isError = input.toIntOrNull() == null,
            supportingText = if (input.toIntOrNull() == null) {
                { Text("Invalid number") }
            } else {
                null
            }
        )
        Spacer(Modifier.width(8.dp))
        Button(onClick = {
            val new = (decimals - 1).coerceAtLeast(0)
            input = new.toString()
            onChange(new)
        }) { Text("-") }
        Spacer(Modifier.width(4.dp))
        Button(onClick = {
            val new = decimals + 1
            input = new.toString()
            onChange(new)
        }) { Text("+") }
    }
}