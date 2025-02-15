package ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun FlexibleLayout(
    modifier: Modifier = Modifier,
    timeDemo: @Composable (Modifier) -> Unit,
    fileSizeDemo: @Composable (Modifier) -> Unit,
    abbreviationDemo: @Composable (Modifier) -> Unit,
    numberFormatDemo: @Composable (Modifier) -> Unit,
    distanceDemo: @Composable (Modifier) -> Unit,
) {
    val colModifier = Modifier
        .widthIn(max = 500.dp)
        .padding(horizontal = 16.dp)

    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        timeDemo(colModifier)
        fileSizeDemo(colModifier)
        abbreviationDemo(colModifier)
        numberFormatDemo(colModifier)
        distanceDemo(colModifier)
    }
}