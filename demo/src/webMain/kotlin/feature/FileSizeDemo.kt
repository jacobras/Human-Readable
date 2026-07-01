package feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import nl.jacobras.humanreadable.HumanReadable
import ui.CodeExample
import ui.DecimalsInput

@Composable
internal fun FileSizeDemo(
    selectedLanguageCode: String,
    modifier: Modifier = Modifier
) {
    val monoBody = MaterialTheme.typography.bodyLarge.copy(fontFamily = FontFamily.Monospace)

    Column(modifier.fillMaxWidth()) {
        Text(
            text = "File size formatting",
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
        var decimals by remember { mutableIntStateOf(2) }
        DecimalsInput(
            decimals = decimals,
            onChange = { decimals = it }
        )
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "HumanReadable.fileSize(myFile, decimals)",
            res = remember(selectedLanguageCode, myFile, decimals) {
                HumanReadable.fileSize(
                    bytes = myFile.toLongOrNull() ?: 0L,
                    decimals = decimals
                )
            }
        )
    }
}