package com.example.syt.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person4
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun DemoBottomSheets() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoModalBottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var isSheetOpen = remember { mutableStateOf(false) }

    if (isSheetOpen.value) {
        ModalBottomSheet(
            onDismissRequest = { isSheetOpen.value = false },
            sheetState = sheetState
        ) {
            BottomSheetContent {
                isSheetOpen.value = false
            }
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Tiktok")}) }, // Đảm bảo hiển thị TopAppBar
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = { BottomAppBarDemo() }
    ) { paddingValues ->
        BodyDemo(
            modifier = Modifier.padding(paddingValues)
        ) {
            isSheetOpen.value = truea
        }
    }
}

@Composable
fun BodyDemo(
    modifier: Modifier = Modifier,
    onShowBottomSheets: () -> Unit
) {
       Column(
           modifier = modifier
               .fillMaxSize()
               .padding(24.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Button(onClick = onShowBottomSheets) {
               Text("Show Bottom Sheet")
           }
       }
}

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    hideBottomSheet: () -> Unit
) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Spacer(Modifier.height(56.dp))
        Text("Bottom Sheet Content")
        Spacer(Modifier.height(24.dp))
        Button(onClick = hideBottomSheet) {
            Text("Close")
        }
    }
}

@Composable
fun BottomAppBarDemo() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val centerVerticalGuide = createGuidelineFromStart(0.5f)

        val (leftMenu, rightMenu) = createRefs()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.constrainAs(leftMenu) {
                start.linkTo(parent.start)
                end.linkTo(centerVerticalGuide, margin = 32.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = { Icon(Icons.Default.Home, contentDescription = "") },
                label = {
                    Text("Home")
                }
            )
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { Icon(Icons.Default.Person4, contentDescription = "") },
                label = {
                    Text("Friend")
                }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.constrainAs(rightMenu) {
                start.linkTo(centerVerticalGuide, margin = 32.dp)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        ) {
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { Icon(Icons.Default.CreditCard, contentDescription = "") },
                label = {
                    Text("Card")
                }
            )
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { Icon(Icons.Default.Person, contentDescription = "") },
                label = {
                    Text("Me")
                }
            )
        }
    }
}