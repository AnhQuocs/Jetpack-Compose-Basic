package com.example.syt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp)
    ) {

        items(20) {
            index ->
            Item(index = index)
        }

    }
}

@Composable
fun Item(modifier: Modifier = Modifier, index: Int) {
    Box(
        modifier = Modifier
            .background(
                color = Color(0xFF33CC66),
                shape = RoundedCornerShape(12.dp)
            )
            .aspectRatio(1f).clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("Category $index", style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ))
    }
}