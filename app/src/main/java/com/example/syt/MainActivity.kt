package com.example.syt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardDoubleArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
        Column (modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.padding(top = 24.dp))
            Ingredients()
            Spacer(modifier = Modifier.padding(top = 12.dp))
        }
}

@Composable
fun Ingredients(modifier: Modifier = Modifier) {
    ConstraintLayout {

        val configuration = LocalConfiguration.current
        val sreenWidth = configuration.screenWidthDp
        val itemWidth = (sreenWidth * 0.25).dp

        val (tvIngredients, imgArrow) = createRefs()

        Text("Ingredients", style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 14.sp,
            color = Color(0xFFFB7D8A)
        ),
            modifier = Modifier.constrainAs(tvIngredients) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "",
            tint = Color(0xFFFB7D8A),
            modifier = Modifier.size(24.dp).constrainAs(imgArrow) {
                start.linkTo(tvIngredients.end, margin = 4.dp)
                bottom.linkTo(tvIngredients.bottom)
            }
        )

        val(lineOne, lineTwo) = createRefs()

        ConstraintLayout(modifier = Modifier.fillMaxWidth().constrainAs(lineOne){
            start.linkTo(tvIngredients.start)
            top.linkTo(tvIngredients.bottom)
        }.background(color = Color(0xFF33CC66))) {

            val(e1, e2, e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1, e2, e3, chainStyle = ChainStyle.Spread)

            Ingredient(
                icon = R.drawable.leaf,
                value = 8,
                unit = null,
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e1) {lineOneChain}
            )
            Ingredient(
                icon = R.drawable.leaf,
                value = 2,
                unit = null,
                name = "Lemon Wedges",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e2) {lineOneChain}
            )
            Ingredient(
                icon = R.drawable.leaf,
                value = 30,
                unit = "ml",
                name = "Lemon Juice",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e3) {lineOneChain}
            )

        }

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(lineTwo){
            start.linkTo(tvIngredients.start)
            top.linkTo(lineOne.bottom, margin = 14.dp)
        }.background(color = Color(0xFF33CC66))) {

            val(e1, e2, e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1, e2, e3, chainStyle = ChainStyle.Spread)

            Ingredient(
                icon = R.drawable.leaf,
                value = 6,
                unit = null,
                name = "Ice Cubes",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e1) {lineOneChain}
            )
            Ingredient(
                icon = R.drawable.leaf,
                value = 2,
                unit = "tbsp",
                name = "Sugar",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e2) {lineOneChain}
            )
            Ingredient(
                icon = R.drawable.leaf,
                value = 30,
                unit = "ml",
                name = "Club Soda",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e3) {lineOneChain}
            )

        }
    }
}

@Composable
fun Ingredient(
    @DrawableRes icon: Int,
    value: Int,
    unit: String?,
    name: String,
    modifier: Modifier = Modifier
) {

    val backgroundColor = Color(0xFFFEF9E4)
    val borderColor = Color(0xFFFBE897).copy(alpha = 0.7f)

    ConstraintLayout(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor, shape = CircleShape)
            .border(BorderStroke(width = 1.dp, color = borderColor))
    ) {
        val horizontalGuideLine = createGuidelineFromTop(0.5f)

        val imgIcon = createRef()
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.constrainAs(imgIcon){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(horizontalGuideLine)
            height = Dimension.fillToConstraints
        },
            contentScale = ContentScale.FillHeight
        )

        val (tvValue, tvUnit, tvName) = createRefs()

        val verticalGuideLine = createGuidelineFromStart(0.5f)
        val valueTextColor = Color(0xFFFB7D8A)

        Text(text = value.toString(), style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            lineHeight = 14.sp,
            color = valueTextColor
        ),
            modifier = Modifier.constrainAs(tvValue) {
                top.linkTo(horizontalGuideLine, margin = 2.dp)
                end.linkTo(verticalGuideLine, margin = 2.dp)
            }
        )

        unit?.let {
            Text(text = unit, style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                color = valueTextColor
            ),
                modifier = Modifier.constrainAs(tvUnit) {
                    top.linkTo(tvValue.bottom, margin = -4.dp)
                    end.linkTo(tvValue.end)
                }
            )
        }

        val bottomBarrier = createBottomBarrier(tvValue, tvUnit)
        val endGuideLine10 = createGuidelineFromEnd(0.1f)

        Text(text = name, style = TextStyle(
            color = Color(0xFF1E2742),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp,
        ),
            modifier = Modifier.constrainAs(tvName) {
                start.linkTo(verticalGuideLine, margin = 4.dp)
                bottom.linkTo(bottomBarrier)
                top.linkTo(tvValue.top)
                end.linkTo(endGuideLine10)
                width = Dimension.fillToConstraints
            },
            maxLines = 2,
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientPreView() {
    Row () {
//        Ingredient(modifier = Modifier.size(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYTTheme {
        HomeScreenApp()
    }
}