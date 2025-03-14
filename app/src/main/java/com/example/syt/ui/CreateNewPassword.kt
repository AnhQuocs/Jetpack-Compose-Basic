package com.example.syt.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.syt.ui.theme.AppTheme

@Composable
fun CreateNewPasswordScreen() {
    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp).background(color = AppTheme.appColor.backgroundColor)
    ) {
        Text(
            "Create New Password \uD83D\uDD10",
            style = AppTheme.appTypography.largeTitle.copy(
                    color = AppTheme.appColor.textBodyColor
                )
        )
    }
}