package com.example.syt.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController

@Composable
fun <T> NavController.GetResultOneTime(key: String, onResult: (T?) -> Unit) {
    val valueScreenResult = currentBackStackEntry
        ?.savedStateHandle
        ?.getStateFlow<T?>(key, null)
        ?.collectAsState()

    LaunchedEffect(valueScreenResult?.value) {
        if (valueScreenResult?.value != null) {
            onResult(valueScreenResult.value)
            currentBackStackEntry?.savedStateHandle?.remove<T>(key)
        }
    }
}