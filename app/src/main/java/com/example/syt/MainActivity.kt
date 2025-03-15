package com.example.syt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.syt.ui.CreateNewPasswordScreen
import com.example.syt.ui.profile.LoginScreen
import com.example.syt.ui.theme.AppTheme
import com.example.syt.ui.theme.SYTTheme

// step 1: define ComposableLocal
// step 2: bind composable
// step 3: using

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainApp()
                }

        }
    }
}

@Composable
fun MainApp() {
    LoginScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYTTheme {
        MainApp()
    }
}








// Composition Local - 11/03/2025

//Header("Jetpack Compose")
//Spacer(modifier = Modifier.height(12.dp))
//Text("Composition local", color = LocalAppColor.current.bodyTextColor, fontSize = 18.sp)
//Spacer(modifier = Modifier.height(12.dp))
//Body("Changeable text color", bodyTextColor)
//Spacer(modifier = Modifier.height(12.dp))
//Button(
//onClick = {
//    bodyTextColor = getColor()
//}
//) {
//    Text("Change text color")
//}

//@Composable
//fun Header(title: String) {
//    Text(title, style = TextStyle(color = Color.Black, fontSize = 24.sp))
//}
//
//@Composable
//fun Body(content: String, bodyTextColor: Color) {
//    CompositionLocalProvider(
//        LocalAppColor provides LocalAppColor.current.copy(bodyTextColor = bodyTextColor)
//    ) {
//        Column() {
//            Text(content, style = TextStyle(color = LocalAppColor.current.bodyTextColor))
//            Spacer(modifier = Modifier.height(12.dp))
//            ImageFeature()
//        }
//    }
//}
//
//@Composable
//fun ImageFeature() {
//    Row() {
//        Icon(Icons.Outlined.Person, contentDescription = null)
//        Spacer(modifier = Modifier.width(12.dp))
//        Icon(Icons.Outlined.Refresh, contentDescription = null)
//    }
//

//data class AppColor(val bodyTextColor: Color)
//
//val LocalAppColor = compositionLocalOf { AppColor(bodyTextColor = Color.Black) }
//
//fun getColor(): Color {
//    val listColors = listOf(Color.Blue, Color.Red, Color.Yellow, Color.Cyan, Color.LightGray)
//    val index = Random.nextInt(0, 4)
//    return listColors[index]
//}


// ** Navigation
//val navController = rememberNavController()
//SYTTheme {
//    // navHost <---- composable,
//    // navController <---- navigate
//    NavHost(navController = navController, startDestination = "home") {
//        //route: home
//        composable("home") {
//            HomeScreen(
//                openCategoryAction = {
//                    navController.navigate("category")
//                },
//                openMyAccountScreen = {
//                    navController.navigate("myAccount")
//                },
//                editCustomerInfo = {
//                    navController.navigate("customerInfo")
//                },
//            )
//        }
//
//        //route: category
//        composable("category") {
//            CategoryScreen(openProductDetail = {
//                    productId ->
//                navController.navigate("productDetail/$productId")
//            })
//        }
//
//        // route: product detail
//        // lấy dữ liệu từ category screen
//        composable("productDetail/{productId}",
//            arguments = listOf(
//                navArgument("productId") {
//                    type = NavType.StringType
//                }
//            )) {
//                backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("productId")
//            requireNotNull(productId)
//            ProductDetailScreen(productId = productId, checkout = {
//                    cartId, customerId ->
//                navController.navigate("checkout/$cartId/$customerId")
//            },
//                backAction = {navController.popBackStack()}
//            )
//        }
//
//        // route: checkout
//        composable("checkout/{cartId}/{customerId}",
//            arguments = listOf(
//                navArgument("cartId") {
//                    type = NavType.StringType
//                },
//                navArgument("customerId") {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//                navBackStackEntry ->
//            navBackStackEntry.arguments?.let {
//                    argument ->
//                val cartId = argument.getString("cartId")
//                val customerId = argument.getString("customerId")
//                requireNotNull(cartId)
//                requireNotNull(customerId)
//                CheckoutScreen(cartId = cartId, customerId = customerId) {
//                    navController.navigate("checkoutSuccess")
//                }
//            }
//        }
//
//        //route: checkout success
//        composable("checkoutSuccess") {
//            CheckoutSuccessScreen(goHomeAction = {
//                navController.popBackStack("home", inclusive = false, saveState = true)
//            }, viewOrderDetailAction = {})
//        }
//
//        // route: customer
//        navigation(route = "customer", startDestination = "myAccount") {
//            //route: my account
//            composable("myAccount") {
//                MyAccountScreen(navController = navController, openAddressScreen = {
//                        addressId ->
//                    val route = if (addressId == null) "addressDetail" else "addressDetail?addressId=$addressId"
//                    navController.navigate(route)
//                })
//            }
//
//            //route: customerInfo
//            composable("customerInfo") {
//                CustomerInfoScreen {
//                    navController.popBackStack()
//                }
//            }
//
//            //route: address detail
//            composable("addressDetail") {
//                AddressDetailScreen(null, saveAddressAndBack = {})
//            }
//            composable("addressDetail?addressId={addressId}",
//                arguments = listOf(
//                    navArgument("addressId") {
//                        type = NavType.StringType
//                        nullable = true
//                    }
//                )
//            ) {
//                    backStackEntry ->
//                val addressId = backStackEntry.arguments?.getString("addressId")
//                AddressDetailScreen(addressId, saveAddressAndBack = {
//                        addressId ->
//                    navController.previousBackStackEntry?.savedStateHandle?.set("new_address_id", addressId)
//                    navController.popBackStack()
//                })
//            }
//        }
//    }
//}





// *** State - 05/03/2025
//@Composable
//fun LoginScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Log.e("frank", "login screen start")
//        Welcome()
//
//        var email by rememberSaveable { mutableStateOf("") }
//        var password by rememberSaveable { mutableStateOf("") }
//
//        EmailTextField(email, { email = it })
//        Spacer(Modifier.padding(bottom = 12.dp))
//        PasswordTextField(password, { password = it })
//
//        Spacer(Modifier.padding(bottom = 12.dp))
//
//        Button(onClick = {}, modifier = Modifier.width(280.dp)) {
//            Text("Login")
//        }
//
//        Log.e("frank", "login screen end")
//    }
//}
//
//@Composable
//fun EmailTextField(email: String, onEmailChange: (String) -> Unit) {
//    Log.e("frank", "email")
//    OutlinedTextField (
//        value = email,
//        onValueChange = onEmailChange,
//        label = {
//            Text("Email", style = TextStyle(color = Color.Gray, fontSize = 15.sp))
//        },
//        shape = MaterialTheme.shapes.medium
//    )
//}
//
//@Composable
//fun PasswordTextField(password: String, onPasswordChange: (String) -> Unit) {
//    Log.e("frank", "password")
//    OutlinedTextField (
//        value = password,
//        onValueChange = onPasswordChange,
//        label = {
//            Text("Password", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
//        },
//        shape = MaterialTheme.shapes.medium
//    )
//}
//
////state less
//@Composable
//fun Welcome() {
//    Log.e("frank", "welcome start")
//    Text(
//        "Login to your account",
//        style = TextStyle (
//            fontSize = 22.sp,
//            color = Color(0xFF33CC66)
//        )
//    )
//    Log.e("frank", "welcome end")
//}



// *** List and Grid - Lazy Column - Lazy Row - 04/03/2025

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