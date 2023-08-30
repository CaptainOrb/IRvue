package com.captain.irvue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer
import com.captain.irvue.ui.theme.IRvueTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IRvueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var appInitialized by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(0f) } // Initialize progress

    LaunchedEffect(Unit) {
        // Simulate app initialization by gradually updating progress
        while (progress < 1f) {
            delay(50) // Adjust the delay time as needed
            progress += 0.025f // Increment the progress
        }
        appInitialized = true
    }

    if (appInitialized) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            SelectionScreen(Modifier)
        }
    } else {
        LoadingScreen(progress) // Pass the progress to the LoadingScreen
    }
}

@Composable
fun LoadingScreen(progress: Float) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val logo = painterResource(R.drawable.logoonly_removebg_preview__1_)
        Image(painter = logo, contentDescription = "IRvue Logo",
            modifier = Modifier
//                .rotate(rotationAngle)
                .graphicsLayer {
                    rotationZ = rotationAngle
                }
                .size(180.dp)
        )
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "IRvue",
            color = Color.LightGray,
            fontSize = 32.sp,
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.ExtraLight
        )
        LinearProgressIndicator(
            progress = progress,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .height(40.dp)
                .width(240.dp)
                .padding(16.dp)
        )
        Text(
            text = "Loading: %.1f%%".format(progress * 100),
            color = Color.White,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "FORESEEN THE UNSEEN",
            color = Color.LightGray,
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.ExtraLight
        )
        Spacer(modifier = Modifier.height(10.dp))

    }
}

val colors = listOf(Color.Red, Color.Green, Color.Blue)

@Composable
fun SelectionScreen(modifier: Modifier) {
    var page by remember { mutableStateOf(0) }
    when (page){
        0 -> Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Welcome to IRvue",
                color = Color.LightGray,
                fontSize = 28.sp,
                fontFamily = FontFamily.Serif, fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(58.dp))
            Text(
                text = "BCA Learning Institute",
                color = Color(120,205,250),
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(70.dp))
            Button(
                onClick =
                {
                    page = 1
                },
                modifier = Modifier
                    .height(55.dp)
                    .width(264.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
            ) {
                Text(
                    text = "STALL",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(Modifier.height(36.dp))
            Button(
                onClick =
                {
                    page = 2
                },
                modifier = Modifier
                    .height(55.dp)
                    .width(264.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
            ) {
                Text(
                    text = "BUFFET",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(Modifier.height(36.dp))
            Button(
                onClick =
                {
                    page = 3
                },
                modifier = Modifier
                    .height(55.dp)
                    .width(264.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
            ) {
                Text(
                    text = "A801",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(Modifier.height(36.dp))
            Button(
                onClick =
                {
                    page = 4
                },
                modifier = Modifier
                    .height(55.dp)
                    .width(264.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
            ) {
                Text(
                    text = "A802",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
        1 -> Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var person by remember {
                mutableStateOf(0)
            }

            LaunchedEffect(key1 = Unit, block = {
                while (true) {
                    delay(3000)
                    person = (75..120).random()
                }
            })

            val nextColor by remember(person) {
                mutableStateOf(colors.random())
            }

            val text by remember(person) { mutableStateOf("$person") }
            val colorNum by animateColorAsState(targetValue = nextColor)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "BCA Learning Institute",
                    color = Color(100, 185, 230),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(84.dp))
                Text(
                    text = "STALL",
                    color = Color(100, 185, 180),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold
                )
                Box(
                    modifier = Modifier
                        .padding(60.dp)
                        .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(8.dp))
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        color = colorNum,
                        fontSize = 100.sp,
                    )
                }
                Spacer(Modifier.height(60.dp))
                Button(
                    onClick = { page = 0 },
                    modifier = Modifier
                        .height(45.dp)
                        .width(240.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
                ) {
                    Text(
                        text = "Back",
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        2 -> Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var person by remember {
                mutableStateOf(0)
            }

            LaunchedEffect(key1 = Unit, block = {
                while (true) {
                    delay(2000)
                    person = (101..205).random()
                }
            })

            val nextColor by remember(person) {
                mutableStateOf(colors.random())
            }

            val text by remember(person) { mutableStateOf("$person") }
            val colorNum by animateColorAsState(targetValue = nextColor)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "BCA Learning Institute",
                    color = Color(100, 185, 230),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(84.dp))
                Text(
                    text = "BUFFET",
                    color = Color(100, 185, 180),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold
                )
                Box(
                    modifier = Modifier
                        .padding(60.dp)
                        .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(8.dp))
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        color = colorNum,
                        fontSize = 100.sp,
                    )
                }
                Spacer(Modifier.height(60.dp))
                Button(
                    onClick = { page = 0 },
                    modifier = Modifier
                        .height(45.dp)
                        .width(240.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
                ) {
                    Text(
                        text = "Back",
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        3 -> Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var person by remember {
                mutableStateOf(0)
            }

            LaunchedEffect(key1 = Unit, block = {
                while (true) {
                    delay(3000)
                    person = (5..36).random()
                }
            })

            val nextColor by remember(person) {
                mutableStateOf(colors.random())
            }

            val text by remember(person) { mutableStateOf("$person") }
            val colorNum by animateColorAsState(targetValue = nextColor)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "BCA Learning Institute",
                    color = Color(100, 185, 230),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(84.dp))
                Text(
                    text = "A801",
                    color = Color(100, 185, 180),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold
                )
                Box(
                    modifier = Modifier
                        .padding(60.dp)
                        .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(8.dp))
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        color = colorNum,
                        fontSize = 100.sp,
                    )
                }
                Spacer(Modifier.height(60.dp))
                Button(
                    onClick = { page = 0 },
                    modifier = Modifier
                        .height(45.dp)
                        .width(240.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
                ) {
                    Text(
                        text = "Back",
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        4 -> Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var person by remember {
                mutableStateOf(0)
            }

            LaunchedEffect(key1 = Unit, block = {
                while (true) {
                    delay(3000)
                    person = (0..36).random()
                }
            })

            val nextColor by remember(person) {
                mutableStateOf(colors.random())
            }

            val text by remember(person) { mutableStateOf("$person") }
            val colorNum by animateColorAsState(targetValue = nextColor)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "BCA Learning Institute",
                    color = Color(100, 185, 230),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(84.dp))
                Text(
                    text = "A802",
                    color = Color(100, 185, 180),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold
                )
                Box(
                    modifier = Modifier
                        .padding(60.dp)
                        .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(8.dp))
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        color = colorNum,
                        fontSize = 100.sp,
                    )
                }
                Spacer(Modifier.height(60.dp))
                Button(
                    onClick = { page = 0 },
                    modifier = Modifier
                        .height(45.dp)
                        .width(240.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
                ) {
                    Text(
                        text = "Back",
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    IRvueTheme {
//        App()
        Compose()
    }
}

@Composable
fun Compose() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var person by remember {
            mutableStateOf(0)
        }

        LaunchedEffect(key1 = Unit, block = {
            while (true) {
                delay(5000)
                person = (55..130).random()
            }
        })

        val nextColor by remember(person) {
            mutableStateOf(colors.random())
        }

        val text by remember(person) { mutableStateOf("$person") }
        val colorNum by animateColorAsState(targetValue = nextColor)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(30.dp))
            Text(
                text = "BCA Learning Institute",
                color = Color(100, 185, 230),
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(110.dp))
            Text(
                text = "STALL",
                color = Color(100, 185, 180),
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold
            )
            Box(
                modifier = Modifier
                    .padding(60.dp)
                    .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(8.dp))
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$person",
                    color = colorNum,
                    fontSize = 100.sp,
                )
            }
            Spacer(Modifier.height(110.dp))
            Button(
                onClick = {  },
                modifier = Modifier
                    .height(45.dp)
                    .width(240.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(120, 80, 215))
            ) {
                Text(
                    text = "Back",
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

