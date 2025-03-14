package com.example.syt.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.syt.ui.CreateNewPasswordScreen

// largeTitle
// title
// subtitle
// body

data class AppTypography (
    val largeTitle: TextStyle = TextStyle.Default,
    val title: TextStyle = TextStyle.Default,
    val subtitle: TextStyle = TextStyle.Default,
    val body: TextStyle = TextStyle.Default,
)

data class AppColor(
    val textBodyColor: Color = Color(0xFF212121),
    val backgroundColor: Color = Color.Unspecified
)

data class AppShape (val smallShape: Shape)

data class AppSpacing(val smallSpacing: Dp = 12.dp)

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography()
}

val LocalAppColor = staticCompositionLocalOf {
    AppColor()
}

@Composable
fun AppTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val typography = AppTypography(
        largeTitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        ),
        title = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        subtitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        body = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
    )

    val appColor = if(isDark) {
        AppColor(
            textBodyColor = Color.Black,
            backgroundColor = Color.White
        )
    } else {
        AppColor(
            textBodyColor = Color.White,
            backgroundColor = Color.Black
        )
    }

    CompositionLocalProvider(LocalAppTypography provides typography, LocalAppColor provides appColor) {
        content.invoke()
    }
}

object AppTheme {
    val appTypography: AppTypography
    @Composable
    get() = LocalAppTypography.current

    val appColor: AppColor
    @Composable
    get() = LocalAppColor.current
}

@Preview(showBackground = true, showSystemUi = true , name = "Light Theme")
@Composable
fun AppThemePreview () {
    AppTheme(isDark = false) {
        CreateNewPasswordScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true , name = "Dark Theme")
@Composable
fun AppThemePreviewDarkTheme () {
    AppTheme(isDark = true) {
        CreateNewPasswordScreen()
    }
}