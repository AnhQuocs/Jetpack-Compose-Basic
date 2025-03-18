package com.example.syt.ui.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DemoBottomSheets() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoBottomSheetScaffold() {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    val showBottomSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.expand()
        }
    }

    val hideBottomSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.partialExpand()
        }
    }

    BottomSheetScaffold(scaffoldState = scaffoldState, sheetContent = {
        BottomSheetContent {
            //hide bottom sheet
            hideBottomSheet()
        }
    }) {

        Scaffold(
            bottomBar = {}
        ) { paddingValues ->
            BodyDemo(
                modifier = Modifier.padding(paddingValues)
            ) {
                // show bottom sheet
                showBottomSheet()
            }

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

