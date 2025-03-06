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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddressDetailScreen(
    addressId: String?,
    saveAddressAndBack: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        var saveableAddressId by rememberSaveable { mutableStateOf("") }

        if(addressId.isNullOrEmpty()) {
            Text("Add new address")
        } else {
            Text("Edit address with id: $addressId")
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = saveableAddressId,
            onValueChange = {saveableAddressId = it},
            enabled = (addressId.isNullOrEmpty())
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                saveAddressAndBack(saveableAddressId)
            }
        ) {
            Text("Save")
        }
    }
}