package com.example.syt.ui.checkout

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
fun CheckoutScreen(cartId: String, customerId: String, placeOrderAction: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Processing cart with id: $cartId for customer with id: $customerId")
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {placeOrderAction()}
        ) {
            Text("Place order")
        }
    }
}