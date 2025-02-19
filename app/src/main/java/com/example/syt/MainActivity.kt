package com.example.syt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(24.dp, 36.dp, 24.dp, 24.dp)
    ) {
        LoginTextField(email = email, onMailChange = {email = it})
        Spacer(modifier = Modifier.padding(top = 12.dp))
        PasswordTextField(password = password, onPasswordChange = {password = it})
        Spacer(modifier = Modifier.padding(top = 24.dp))
        LoginButton()
    }
}

@Composable
fun LoginTextField(email : String, onMailChange : (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = onMailChange,
        label = {Text("Email Address", color = Color.Gray)},
        leadingIcon = {
            Icon(
                Icons.Default.Email,
                contentDescription = "",
                tint = Color(0xFF33CC66)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun PasswordTextField(password : String, onPasswordChange : (String)  -> Unit) {
    var isShowPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = {Text("Password", color = Color.Gray)},
        leadingIcon = {
            Icon(
                Icons.Default.Lock,
                contentDescription = "",
                tint = Color(0xFF33CC66)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    isShowPassword = !isShowPassword
                }
            ) {
                Icon(
                    if(isShowPassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = "",
                    tint = Color(0xFF33CC66)
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        visualTransformation = if(isShowPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF33CC66)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text("Login", fontSize = 24.sp, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYTTheme {
        HomeScreenApp()
    }
}