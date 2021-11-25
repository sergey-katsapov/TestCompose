package android.test.compose.event

sealed class LoginScreenEvent {
    data class EnteredUsername(val username: String) : LoginScreenEvent()
    object SaveData : LoginScreenEvent()
}