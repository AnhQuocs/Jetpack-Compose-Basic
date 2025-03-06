package com.example.syt.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    openCategoryAction: () -> Unit,
    openMyAccountScreen: () -> Unit,
    editCustomerInfo: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Home Screen",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF33CC66)
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                openCategoryAction()
            }
        ) {
            Text("Open Category")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                openMyAccountScreen()
            }
        ) {
            Text("Open My Account")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                editCustomerInfo()
            }
        ) {
            Text("Edit customer information")
        }
    }
}