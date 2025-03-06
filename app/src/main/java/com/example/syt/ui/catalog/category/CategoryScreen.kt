package com.example.syt.ui.catalog.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryScreen(openProductDetail: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Category Screen")
        Spacer(modifier = Modifier.height(24.dp))

        var productId by rememberSaveable {
            mutableStateOf("")
        }

        OutlinedTextField(value = productId, onValueChange = {
            productId = it
        }, modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.medium)

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {openProductDetail(productId)}) {
            Text("Open Product Detail")
        }
    }
}