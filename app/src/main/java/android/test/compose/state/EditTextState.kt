package android.test.compose.state

data class EditTextState(
    val text: String = "",
    val error: Error? = null
)