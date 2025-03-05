package com.example.syt

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.syt.ui.theme.SYTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SYTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    CategoryScreen()
                    HomeScreenApp()
                }
            }
        }
    }
}

@Composable
fun HomeScreenApp() {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            LoginScreen()
        }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.e("frank", "login screen start")
        Welcome()

        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        EmailTextField(email, { email = it })
        Spacer(Modifier.padding(bottom = 12.dp))
        PasswordTextField(password, { password = it })

        Spacer(Modifier.padding(bottom = 12.dp))

        Button(onClick = {}, modifier = Modifier.width(280.dp)) {
            Text("Login")
        }

        Log.e("frank", "login screen end")
    }
}

@Composable
fun EmailTextField(email: String, onEmailChange: (String) -> Unit) {
    Log.e("frank", "email")
    OutlinedTextField (
        value = email,
        onValueChange = onEmailChange,
        label = {
            Text("Email", style = TextStyle(color = Color.Gray, fontSize = 15.sp))
        },
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
    Log.e("frank", "password")
    OutlinedTextField (
        value = password,
        onValueChange = onPasswordChange,
        label = {
            Text("Password", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
        },
        shape = MaterialTheme.shapes.medium
    )
}

//state less
@Composable
fun Welcome() {
    Log.e("frank", "welcome start")
    Text(
        "Login to your account",
        style = TextStyle (
            fontSize = 22.sp,
            color = Color(0xFF33CC66)
        )
    )
    Log.e("frank", "welcome end")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYTTheme {
        HomeScreenApp()
    }
}






// List and Grid - Lazy Column - Lazy Row - 04/03/2025

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun VideoDetailScreen(modifier: Modifier = Modifier, @DrawableRes icon: Int, name: String) {
//    val listVideos = fakeVideoData()
//    LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp)) {
//        stickyHeader {
//            Column(modifier = Modifier.background(color = Color.White)) {
//                Header()
//                FilterCategory()
//            }
//        }
//
//        items(listVideos) {
//            video ->
//            NextVideoInfo(thumb = R.drawable.screen_yt_as, channel = "AnhQuocs", videoTitle = video.videoTitle, views = video.views, timeAgo = video.timeAgo)
//        }
//
//    }
//}
//
//@Composable
//fun Header() {
//    Box(modifier = Modifier
//        .fillMaxWidth()
//        .height(200.dp)
//        .background(color = Color(0xFF33CC66))
//    )
//}
//
//@Composable
//fun FilterCategory(modifier: Modifier = Modifier) {
//    var isSelected by remember { mutableStateOf(false)}
//    val listCategorys = fakeCategory()
//    LazyRow (modifier = Modifier) {
//        items(listCategorys) {
//            category ->
//            FilterChip(
//                selected = isSelected,
//                onClick = {isSelected = !isSelected},
//                label = {Text(category.name)},
//                modifier = Modifier
//                    .padding(8.dp)
//            )
//        }
//
//    }
//}
//
//fun fakeCategory(): List<VideoCategory> {
//    val list = mutableListOf<VideoCategory> ()
//    for(index in 1..10) {
//        val category = VideoCategory(id = index, name = "Category $index")
//        list.add(category)
//    }
//    return list
//}
//
//fun fakeVideoData(): List<VideoYT> {
//    val list = mutableListOf<VideoYT>()
//    for(index in 1..10) {
//        val video = VideoYT(videoTitle = "Video $index", views = index, timeAgo = "$index days")
//        list.add(video)
//    }
//    return list
//}
//
//@Composable
//fun NextVideoInfo(@DrawableRes thumb: Int, channel: String, videoTitle: String, views: Int, timeAgo: String, modifier: Modifier = Modifier) {
//
//    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
//        val(imgThumbnail, imgAvatar, tvVideoTitle, layoutInfo, imgMore) = createRefs()
//
//        Image(
//            painter = painterResource(thumb),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .clip(MaterialTheme.shapes.medium)
//                .constrainAs(imgThumbnail) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    width = Dimension.fillToConstraints
//                }
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.toi),
//            contentDescription = null,
//            modifier = Modifier
//                .size(46.dp)
//                .clip(CircleShape)
//                .border(1.dp, color = Color.Gray, CircleShape)
//                .constrainAs(imgAvatar) {
//                    top.linkTo(imgThumbnail.bottom, margin = 12.dp)
//                    start.linkTo(parent.start, margin = 12.dp)
//                }
//        )
//
//        Icon(
//            Icons.Default.MoreVert,
//            contentDescription = null,
//            modifier = Modifier
//                .size(24.dp)
//                .constrainAs(imgMore) {
//                    top.linkTo(imgThumbnail.bottom, margin = 12.dp)
//                    end.linkTo(parent.end, margin = 12.dp)
//                }
//        )
//
//        Text(
//            videoTitle,
//            style = TextStyle(
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Normal
//            ),
//            modifier = Modifier
//                .constrainAs(tvVideoTitle) {
//                    start.linkTo(imgAvatar.end, margin = 8.dp)
//                    top.linkTo(imgThumbnail.bottom, margin = 12.dp)
//                    end.linkTo(imgMore.start, margin = 4.dp)
//                    width = Dimension.fillToConstraints
//                }
//        )
//
//        Row (
//            modifier = Modifier.constrainAs(layoutInfo) {
//                top.linkTo(tvVideoTitle.bottom, margin = 4.dp)
//                start.linkTo(tvVideoTitle.start)
//            }) {
//            Text(
//                channel,
//                style = TextStyle(
//                    color = Color(0xFF6C6C6C),
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 14.sp
//                )
//            )
//            Text(" · ", style = TextStyle(color = Color(0xFF6C6C6C), fontWeight = FontWeight.Normal, fontSize = 14.sp))
//            Text(
//                "$views views",
//                style = TextStyle (
//                    color = Color(0xFF6C6C6C),
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 14.sp
//                )
//            )
//            Text(" · ", style = TextStyle(color = Color(0xFF6C6C6C), fontWeight = FontWeight.Normal, fontSize = 14.sp))
//            Text(
//                timeAgo,
//                style = TextStyle(
//                    color = Color(0xFF6C6C6C),
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 14.sp
//                )
//            )
//        }
//    }
//}