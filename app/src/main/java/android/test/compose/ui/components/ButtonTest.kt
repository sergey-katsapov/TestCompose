package android.test.compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonTest(
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {

        Column(
            content = {
                androidx.compose.material3.Button(
                    onClick = {
                        if (enabled) {
                            onClick()
                        }
                    },

                    modifier = Modifier
                        .fillMaxSize(),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF144ab0)
                    ),

                    enabled = enabled
                ) {

                    Text(
                        text = text,
                        modifier = Modifier.padding(horizontal = 5.dp),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFffffff)
                    )
                }
            })
    }
}

