package android.test.compose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Edit text with all necessary elements
 */
@Composable
fun EditTextTest(
    modifier: Modifier,
    text: String = "",
    hint: String = "",
    enabled: Boolean = true,
    maxLength: Int = 100,
    error: String = "",
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    singleLine: Boolean = true,
    maxLines: Int = 3,
    onValueChange: (String) -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }
    val isError = error.isNotBlank()

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { enteredText ->
                if (enteredText.length <= maxLength) {
                    onValueChange(enteredText)
                }
            },
            enabled = enabled,
            modifier = modifier
                .onFocusChanged { isFocused = it.isFocused },
            textStyle = textStyle,
            label = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.titleSmall,
                    color = if (enabled) {
                        if (isFocused) {
                            if (!isError) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.error
                            }
                        } else {
                            if (!isError) {
                                MaterialTheme.colorScheme.onSurface
                            } else {
                                MaterialTheme.colorScheme.error
                            }
                        }
                    } else {
                        MaterialTheme.colorScheme.outline.copy(
                            alpha = ContentAlpha.disabled
                        )
                    }
                )
            },
            isError = isError,
            singleLine = singleLine,
            maxLines = maxLines,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = backgroundColor,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                cursorColor = MaterialTheme.colorScheme.onSecondaryContainer,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.outline
            )
        )

        if (isError) {
            Text(
                text = error,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
fun EditText_Preview() {
    EditTextTest(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        hint = "Some hint",
        error = "Some error",
        enabled = true,
        onValueChange = {})
}
