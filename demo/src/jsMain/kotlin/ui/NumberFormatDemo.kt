package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import monoBodyOrange
import monoBodyString
import monoBodyStringBold
import nl.jacobras.humanreadable.HumanReadable

@Composable
internal fun NumberFormatDemo(
    selectedLanguageCode: String,
    modifier: Modifier = Modifier
) {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

    Column(modifier.fillMaxWidth()) {
        Text(
            text = "Number formatting",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(16.dp))
        var myNumber by remember { mutableStateOf("1000000.34") }
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
                },
                isError = myNumber.toDoubleOrNull() == null,
                supportingText = if (myNumber.toDoubleOrNull() == null) {
                    { Text("Invalid number") }
                } else {
                    null
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
                onValueChange = { decimals = it },
                isError = decimals.toIntOrNull() == null,
                supportingText = if (decimals.toIntOrNull() == null) {
                    { Text("Invalid number") }
                } else {
                    null
                }
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = buildAnnotatedString {
                appendLine("HumanReadable.number(myNumber, decimals)")
                withStyle(monoBodyStringBold) {
                    append("// \"")
                    append(
                        remember(selectedLanguageCode, myNumber, decimals) {
                            HumanReadable.number(
                                number = myNumber.toDoubleOrNull() ?: 0L,
                                decimals = decimals.toIntOrNull() ?: 0
                            )
                        })
                    append("\"")
                }
            },
            style = monoBody
        )
    }
}