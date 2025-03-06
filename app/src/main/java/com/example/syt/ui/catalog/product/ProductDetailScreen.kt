package com.example.syt.ui.catalog.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailScreen(productId: String, checkout: (String, String) -> Unit, backAction: () -> Unit) {
    Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(24.dp)
    ) {
        Text("Product with id: $productId")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            checkout("224", "9988")
        }) {
            Text("Checkout")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {backAction()}) {
            Text("Back")
        }
    }
}