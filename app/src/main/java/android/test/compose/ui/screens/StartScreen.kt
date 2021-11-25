package android.test.compose.ui.screens

import android.test.compose.event.LoginScreenEvent
import android.test.compose.ui.components.ButtonTest
import android.test.compose.ui.components.EditTextTest
import android.test.compose.viewModels.StartViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StartScreen(
    startViewModel: StartViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ButtonLoginBox(startViewModel = startViewModel)
        InfoText(
            startViewModel = startViewModel
        )
    }
}

@Composable
private fun ButtonLoginBox(
    startViewModel: StartViewModel
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
    ) {
        LoginEditText(startViewModel = startViewModel)
        Spacer(modifier = Modifier.height(20.dp))
        ToastDemo(startViewModel = startViewModel)
    }
}

@Composable
fun ToastDemo(
    startViewModel: StartViewModel
) {
    Column(
        content = {
            ButtonTest(
                onClick = {
                    startViewModel.onEvent(LoginScreenEvent.SaveData)
                },
                text = "test",
                enabled = true
            )
        },
        verticalArrangement = Arrangement.Center
    )
}

@Composable
private fun LoginEditText(
    startViewModel: StartViewModel
) {
    val passwordState = startViewModel.usernameState.value

    EditTextTest(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        text = passwordState.text,
        hint = "test",
        enabled = true,
        onValueChange = { startViewModel.onEvent(LoginScreenEvent.EnteredUsername(username = it)) },
    )
}

@Composable
fun InfoText(
    startViewModel: StartViewModel
) {
    val userNameState = startViewModel.usernameState
    val buttonClickedState = startViewModel.buttonClickedState

    if (buttonClickedState.value) {
        LazyColumn {
            userNameState.value.text.forEach {
                item {
                    Text(
                        text = it.toString(),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

