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
        var myNumber by remember { mutableStateOf("105122.34") }
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
        var decimals by remember { mutableIntStateOf(1) }
        DecimalsInput(
            decimals = decimals,
            onChange = { decimals = it }
        )
        Spacer(Modifier.height(16.dp))

        CodeExample(
            code = "HumanReadable.number(myNumber, decimals)",
            res = remember(selectedLanguageCode, myNumber, decimals) {
                HumanReadable.number(
                    number = myNumber.toDoubleOrNull() ?: 0L,
                    decimals = decimals
                )
            }
        )
        Spacer(Modifier.height(8.dp))
        CodeExample(
            code = "HumanReadable.abbreviation(myNumber, decimals)",
            res = remember(selectedLanguageCode, myNumber, decimals) {
                HumanReadable.abbreviation(
                    number = myNumber.toDoubleOrNull() ?: 0L,
                    decimals = decimals
                )
            }
        )
    }
}