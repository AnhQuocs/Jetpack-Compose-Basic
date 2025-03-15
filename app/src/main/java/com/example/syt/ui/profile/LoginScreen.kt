package com.example.syt.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.syt.ui.component.OtpInputField

@Composable
fun LoginScreen() {

    var otpValue by remember {
        mutableStateOf("")
    }

    val isEnableButton by remember {
        derivedStateOf { otpValue.length == 6 }
    }

    val currentColor = MaterialTheme.colorScheme.copy(primary = Color(0xFF33CC66))

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Login with your pin", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        MaterialTheme (
            colorScheme = currentColor
        ) {
            OtpInputField(
                otpLength = 6,
                onOtpChanged = {
                        otp ->
                    otpValue = otp
                }
            )
        }

        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {},
            enabled = isEnableButton
        ) {
            Text("Login")
        }
    }
}