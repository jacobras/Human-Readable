package ui

import Feature
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FeaturesList(
    selected: Feature,
    onSelect: (Feature) -> Unit
) {
    Column {
        for (feature in Feature.entries) {
            Text(
                text = feature.name,
                fontWeight = if (selected == feature) {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelect(feature) }
                    .padding(8.dp, 4.dp)
            )
        }
    }
}