package ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
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
import nl.jacobras.humanreadable.HumanReadable

@Composable
internal fun FileSizeDemo(selectedLanguageCode: String) {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

    Text(
        text = "File size",
        style = MaterialTheme.typography.headlineLarge
    )
    Text("File size formatting uses base 1024.")
    Spacer(Modifier.height(16.dp))
    var myFile by remember { mutableStateOf("21947") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = buildAnnotatedString {
                withStyle(monoBodyOrange) { append("val ") }
                append("myFile = ")
            },
            style = monoBody
        )
        TextField(
            modifier = Modifier.sizeIn(minWidth = 20.dp),
            value = myFile,
            onValueChange = {
                if (it.length < 16) {
                    myFile = it
                }
            },
            isError = myFile.toLongOrNull() == null,
            supportingText = if (myFile.toLongOrNull() == null) {
                { Text("Invalid number") }
            } else {
                null
            }
        )
        Text(
            text = " bytes",
            style = monoBody
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
            append("HumanReadable.fileSize(myFile, decimals) = ")
            withStyle(monoBodyString) {
                append("\"")
                append(
                    remember(selectedLanguageCode, myFile, decimals) {
                        HumanReadable.fileSize(
                            bytes = myFile.toLongOrNull() ?: 0L,
                            decimals = decimals.toIntOrNull() ?: 0
                        )
                    })
                append("\"")
            }
        },
        style = monoBody
    )
}