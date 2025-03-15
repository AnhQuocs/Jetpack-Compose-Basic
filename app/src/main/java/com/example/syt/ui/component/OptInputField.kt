package com.example.syt.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtpInputField(
    otpLength: Int,
    onOtpChanged: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    var otpValue by remember { mutableStateOf("") }

    val keyboardState = keyboardAsState(KeyboardStatus.Closed)

    val isShowWarning by remember {
        derivedStateOf {
            if (keyboardState.value == KeyboardStatus.Closed) {
                return@derivedStateOf otpValue.length != otpLength
            }
            return@derivedStateOf false
        }
    }

    val focusRequester = remember {
        FocusRequester()
    }

    BasicTextField(
        modifier = Modifier.focusRequester(focusRequester),
        value = otpValue, onValueChange = {
        value ->
            if (value.length <= otpLength && value.all { it in '0'..'9' }) {
                otpValue = value
                onOtpChanged(otpValue)
            }
    },
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                repeat(otpLength) {
                    index ->
                    val char = when {
                        index >= otpValue.length -> ""
                        else -> otpValue[index].toString()
                    }

                    val isFocus = index == otpValue.length
                    OtpCell(
                        char = char,
                        isFocus = isFocus,
                        isShowWarning = isShowWarning,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        })
    )

    LaunchedEffect(key1 = true) {
        focusRequester.requestFocus()
    }
}

@Composable
fun OtpCell(
    char: String,
    isFocus: Boolean,
    isShowWarning: Boolean,
    modifier: Modifier = Modifier
) {
    val borderColor = if(isShowWarning) {
        MaterialTheme.colorScheme.error
    } else if (isFocus){
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondary
    }

    Surface(
        modifier = modifier
            .aspectRatio(1f)
            .border(3.dp, color = borderColor, shape = MaterialTheme.shapes.small)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                char,
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Center
                )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun OtpInputFieldPreview() {
    MaterialTheme{
        Box(modifier = Modifier.padding(24.dp)) {
            OtpInputField(otpLength = 6, onOtpChanged = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OtpCellFocusPreview() {
    MaterialTheme{
        Box(modifier = Modifier.padding(24.dp)) {
            OtpCell("7", isFocus = true, isShowWarning = false)
        }
    }
}