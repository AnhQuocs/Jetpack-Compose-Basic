package com.example.syt.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenTheme() {
    Column(modifier = Modifier.padding(vertical = 48.dp)) {
        CardItem(title = "First Card")
        Spacer(modifier = Modifier.height(12.dp))
        Surface() {
            CardItem(title = "Surface card")
        }
    }
}

@Composable
fun CardItem(title: String) {
    Row() {
        Icon(Icons.Default.Add, contentDescription = "")
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = title, style =  MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenThemePreview() {
    MaterialTheme {
        HomeScreenTheme()
    }
}