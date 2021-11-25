package android.test.compose.viewModels

import android.test.compose.event.EventHandler
import android.test.compose.event.LoginScreenEvent
import android.test.compose.state.EditTextState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : ViewModel(), EventHandler<LoginScreenEvent> {

    private val _usernameState = mutableStateOf(EditTextState())
    val usernameState: State<EditTextState> = _usernameState

    private val _listOfUsernameState = mutableStateOf(EditTextState())
    val listOfUsernameState: State<EditTextState> = _listOfUsernameState

    private val _buttonClickedState = mutableStateOf(false)
    val buttonClickedState: State<Boolean> = _buttonClickedState

    override fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EnteredUsername -> updateUsernameState(event)
            is LoginScreenEvent.SaveData -> saveUsernames()
        }
    }

    private fun updateUsernameState(event: LoginScreenEvent.EnteredUsername) {
        _usernameState.value = usernameState.value.copy(
            text = event.username
        )
    }

    private fun saveUsernames() {
        _listOfUsernameState.value = listOfUsernameState.value.copy(
            text = _usernameState.value.text
        )

        _buttonClickedState.value = true
    }
}