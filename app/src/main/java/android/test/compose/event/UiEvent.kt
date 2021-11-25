package android.test.compose.event

sealed class UiEvent {
    data class Navigate(val route: String, val clearBackStack: Boolean) : UiEvent()
}