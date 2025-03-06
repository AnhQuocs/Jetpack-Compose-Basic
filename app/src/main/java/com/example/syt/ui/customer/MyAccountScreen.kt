package com.example.syt.ui.customer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MyAccountScreen(
    navController: NavController,
    openAddressScreen: (String?) -> Unit
) {
    var addressId by rememberSaveable { mutableStateOf("") }

    val newAddressId by navController.currentBackStackEntry
        ?.savedStateHandle
        ?.getStateFlow("new_address_id", "")
        ?.collectAsState() ?: remember { mutableStateOf("") }

    LaunchedEffect(newAddressId) {
        addressId = newAddressId
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("My account")
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {openAddressScreen(null) }
        ) {
            Text("Add address")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = addressId, onValueChange = {addressId = it})
        Spacer(modifier = Modifier.height(6.dp))
        Button(onClick = {
            openAddressScreen(addressId)
        }) {
            Text("Edit Address")
        }
    }
}