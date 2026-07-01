package ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

fun AnnotatedString.Builder.appendKotlinCode(
    code: String
) {
    var lastIndex = 0

    for (match in TOKEN_REGEX.findAll(code)) {
        if (match.range.first > lastIndex) {
            append(code.substring(lastIndex, match.range.first))
        }

        val groups = match.groupValues
        when {
            groups[1].isNotEmpty() -> withStyle(
                SpanStyle(color = Color(0xFF6aab73), fontWeight = FontWeight.Bold)
            ) { append(match.value) }
            groups[2].isNotEmpty() || groups[3].isNotEmpty() -> withStyle(
                SpanStyle(color = Color(0xFF00627A))
            ) { append(match.value) }
            groups[4].isNotEmpty() -> withStyle(
                SpanStyle(color = Color(0xFF999999))
            ) { append(match.value) }
            else -> append(match.value)
        }

        lastIndex = match.range.last + 1
    }

    if (lastIndex < code.length) {
        append(code.substring(lastIndex))
    }
}

private val TOKEN_REGEX = Regex(
    """(//[^\n]*)""" +                     // 1: comment
        """|(\b[A-Z][A-Za-z0-9_]*\b)""" +           // 2: class name
        """|(\b[a-z_][A-Za-z0-9_]*)(?=\s*\()""" +   // 3: method name
        """|([(),.+*-])"""                             // 4: punctuation
)