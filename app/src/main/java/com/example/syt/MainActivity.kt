package com.example.syt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.syt.ui.theme.SYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SYTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreenApp()
                }
            }
        }
    }
}

@Composable
fun HomeScreenApp() {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }

//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(
//            painter = painterResource(id = R.drawable.picwhite),
//            contentDescription = "",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//    }

    Column(
        modifier = Modifier.padding(12.dp, 96.dp, 12.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (verticalAlignment = Alignment.CenterVertically) {
            TextField(value = "", onValueChange = {}, modifier = Modifier.weight(1f))
            Icon(Icons.Default.Save, contentDescription = "Save", Modifier.size(50.dp).padding(start = 6.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)) {
            TextField(value = "", onValueChange = {}, modifier = Modifier.weight(1f))
            Icon(Icons.Default.Photo, contentDescription = "", Modifier.size(50.dp).padding(start = 6.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(value = "", onValueChange = {}, modifier = Modifier.weight(1f))
            Icon(Icons.Default.Mic, contentDescription = "", Modifier.size(50.dp).padding(start = 6.dp))
        }
    }
}

//@Composable
//fun EmailTextField(email : String, onMailChange : (String) -> Unit) {
//    Column () {
//        Text(
//            "Email Address",
//            fontSize = 18.sp,
//            modifier = Modifier
//                .align(Alignment.Start)
//                .padding(start = 4.dp, top = 36.dp)
//        )
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = onMailChange,
//            label = {Text("Email Address", color = Color.Gray)},
//            leadingIcon = {
//                Icon(
//                    Icons.Default.Email,
//                    contentDescription = "",
//                    tint = Color(0xFF33CC66)
//                )
//            },
//            modifier = Modifier.fillMaxWidth(),
//            shape = MaterialTheme.shapes.medium
//        )
//    }
//}
//
//
//@Composable
//fun PasswordTextField(password : String, onPasswordChange : (String)  -> Unit) {
//    var isShowPassword by remember {
//        mutableStateOf(false)
//    }
//    Column () {
//        Text(
//            "Password",
//            fontSize = 18.sp,
//            modifier = Modifier
//                .align(Alignment.Start)
//                .padding(start = 4.dp)
//        )
//        OutlinedTextField(
//            value = password,
//            onValueChange = onPasswordChange,
//            label = {Text("Password", color = Color.Gray)},
//            leadingIcon = {
//                Icon(
//                    Icons.Default.Lock,
//                    contentDescription = "",
//                    tint = Color(0xFF33CC66)
//                )
//            },
//            trailingIcon = {
//                IconButton(
//                    onClick = {
//                        isShowPassword = !isShowPassword
//                    }
//                ) {
//                    Icon(
//                        if(isShowPassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
//                        contentDescription = "",
//                        tint = Color(0xFF33CC66)
//                    )
//                }
//            },
//            modifier = Modifier.fillMaxWidth(),
//            shape = MaterialTheme.shapes.medium,
//            visualTransformation = if(isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
//        )
//    }
//
//}
//
//@Composable
//fun LoginButton() {
//    Button(
//        onClick = {},
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color(0xFF33CC66)
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(50.dp)
//    ) {
//        Text("Login", fontSize = 22.sp, textAlign = TextAlign.Center)
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYTTheme {
        HomeScreenApp()
    }
}