package com.example.syt

import android.os.Bundle
import android.provider.MediaStore.Video
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.syt.ui.theme.SYTTheme
import com.example.syt.VideoYT

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
        Column (modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.padding(top = 24.dp))
            Spacer(modifier = Modifier.padding(top = 12.dp))
            VideoDetailScreen(Modifier.padding(4.dp), icon = R.drawable.avt, name = "haha")
        }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoDetailScreen(modifier: Modifier = Modifier, @DrawableRes icon: Int, name: String) {
    val listVideos = fakeVideoData()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp)) {
//        item {
//            NextVideoInfo(thumb = R.drawable.screen_yt_as, channel = "AnhQuocs", videoTitle = "How to use Android Studio", views = 1916, timeAgo = "1 day ago", Modifier.padding(bottom = 24.dp))
//            NextVideoInfo(thumb = R.drawable.screen_yt_sleep, channel = "AnhQuocs", videoTitle = "How to sleep 8 hours in 30 minutes", views = 2036, timeAgo = "2 days ago", Modifier.padding(bottom = 24.dp))
//            NextVideoInfo(thumb = R.drawable.screen_yt_sj, channel = "AnhQuocs", videoTitle = "How to get A+ in all subjects", views = 5034, timeAgo = "3 days ago", Modifier.padding(bottom = 24.dp))
//            NextVideoInfo(thumb = R.drawable.screen_yt, channel = "AnhQuocs", videoTitle = "How to get a high paying easy job", views = 5000, timeAgo = "1 day ago", Modifier.padding(bottom = 24.dp))
//            NextVideoInfo(thumb = R.drawable.screen_yt, channel = "AnhQuocs", videoTitle = "How to use Android Studio", views = 1000, timeAgo = "1 day ago", Modifier.padding(bottom = 24.dp))
//            NextVideoInfo(thumb = R.drawable.screen_yt, channel = "AnhQuocs", videoTitle = "How to use Android Studio", views = 1000, timeAgo = "1 day ago", Modifier.padding(bottom = 24.dp))
//        }
        stickyHeader {
            Header()
        }

        items(listVideos) {
            video ->
            NextVideoInfo(thumb = R.drawable.screen_yt_as, channel = "AnhQuocs", videoTitle = video.videoTitle, views = video.views, timeAgo = video.timeAgo)
        }

        item {
            Footer()
        }
    }
}

@Composable
fun Header() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(color = Color(0xFF33CC66))
    )
}

@Composable
fun Footer() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(color = Color(0xFF33CC66))
    )
}

fun fakeVideoData(): List<VideoYT> {
    val list = mutableListOf<VideoYT>()
    for(index in 1..10) {
        val video = VideoYT(videoTitle = "Video $index", views = index, timeAgo = "$index days")
        list.add(video)
    }
    return list
}

@Composable
fun NextVideoInfo(@DrawableRes thumb: Int, channel: String, videoTitle: String, views: Int, timeAgo: String, modifier: Modifier = Modifier) {

    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val(imgThumbnail, imgAvatar, tvVideoTitle, layoutInfo, imgMore) = createRefs()

        Image(
            painter = painterResource(thumb),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium)
                .constrainAs(imgThumbnail) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        Image(
            painter = painterResource(id = R.drawable.toi),
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .border(1.dp, color = Color.Gray, CircleShape)
                .constrainAs(imgAvatar) {
                    top.linkTo(imgThumbnail.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                }
        )

        Icon(
            Icons.Default.MoreVert,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .constrainAs(imgMore) {
                    top.linkTo(imgThumbnail.bottom, margin = 12.dp)
                    end.linkTo(parent.end, margin = 12.dp)
                }
        )

        Text(
            videoTitle,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .constrainAs(tvVideoTitle) {
                    start.linkTo(imgAvatar.end, margin = 8.dp)
                    top.linkTo(imgThumbnail.bottom, margin = 12.dp)
                    end.linkTo(imgMore.start, margin = 4.dp)
                    width = Dimension.fillToConstraints
                }
        )

        Row (
            modifier = Modifier.constrainAs(layoutInfo) {
                top.linkTo(tvVideoTitle.bottom, margin = 4.dp)
                start.linkTo(tvVideoTitle.start)
            }) {
            Text(
                channel,
                style = TextStyle(
                    color = Color(0xFF6C6C6C),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
            Text(" · ", style = TextStyle(color = Color(0xFF6C6C6C), fontWeight = FontWeight.Normal, fontSize = 14.sp))
            Text(
                "$views views",
                style = TextStyle (
                    color = Color(0xFF6C6C6C),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
            Text(" · ", style = TextStyle(color = Color(0xFF6C6C6C), fontWeight = FontWeight.Normal, fontSize = 14.sp))
            Text(
                timeAgo,
                style = TextStyle(
                    color = Color(0xFF6C6C6C),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYTTheme {
        HomeScreenApp()
    }
}