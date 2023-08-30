package com.captain.irvue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//    AppHeader()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SelectionScreen(Modifier)
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppHeader() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "IRvue",
//                        color = Color.LightGray
//                    )
//                },
//                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.DarkGray)
//            )
//        }
//    ) { contentPadding ->
//        // Screen content
//        SelectionScreen(Modifier.padding(contentPadding))
//    }
//}

val colors = listOf(Color.Red, Color.Green, Color.Blue)

@Composable
fun SelectionScreen(modifier: Modifier) {
    var page by remember { mutableStateOf(0) }
    when (page){
        0 -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(40.dp))
                Text(
                    text = "Welcome to IRvue",
                    color = Color.LightGray,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Serif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(58.dp))
                Text(
                    text = "BCA Learning Institute",
                    color = Color(100,185,230),
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(48.dp))
    //        Button(onClick = { /*TODO*/ }) {
    //            Text(text = "This is Button1")
    //        }
                Button(
                    onClick =
                    {
                        page = 1
                    },
                    modifier = Modifier
                        //                .padding(start = 40.dp)
                        .height(55.dp)
                        .width(264.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(140,125,210))
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
                        //                .padding(start = 40.dp)
                        .height(55.dp)
                        .width(264.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(140,125,210))
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
                        //
                    },
                    modifier = Modifier
                        //                .padding(start = 40.dp)
                        .height(55.dp)
                        .width(264.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(140,125,210))
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
                        //
                    },
                    modifier = Modifier
                        //                .padding(start = 40.dp)
                        .height(55.dp)
                        .width(264.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(140,125,210))
                ) {
                    Text(
                        text = "A202",
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
//            Text(text = "Hello World!")
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
                Spacer(Modifier.height(84.dp))
                Text(
                    text = "STALL",
                    color = Color(200, 45, 160),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(66.dp))
                Text(
                    text = text, color = colorNum, fontSize = 100.sp,
                    modifier = Modifier
                        .border(2.dp, Color(105, 205, 216))
                        .padding(all = 70.dp)
                )
                Spacer(Modifier.height(110.dp))
                Button(
                    onClick =
                    {
                        page = 0
                    },
                    modifier = Modifier
                        //                .padding(start = 40.dp)
                        .height(45.dp)
                        .width(240.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(140, 125, 210))
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

@Composable
fun Compose() {
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
        Spacer(Modifier.height(58.dp))
        Text(
            text = "BCA Learning Institute",
            color = Color(100, 185, 230),
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(84.dp))
        Text(
            text = "STALL",
            color = Color(200, 45, 160),
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.height(66.dp))
        Text(
            text = text, color = colorNum, fontSize = 100.sp,
            modifier = Modifier
                .border(2.dp, Color(105, 205, 216))
                .padding(all = 80.dp)
        )
        Spacer(Modifier.height(180.dp))
        Button(
            onClick =
            {
//                page = 0
            },
            modifier = Modifier
                //                .padding(start = 40.dp)
                .height(45.dp)
                .width(240.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(140, 125, 210))
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    IRvueTheme {
//        App()
        Compose()
    }
}

//@Composable
//fun ArtSpaceScreen(){
//    var page by remember { mutableStateOf(1) }
//    when (page){
//        1 -> Column(
//            modifier = Modifier.fillMaxHeight(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Bottom
//        ) {
//            val image = painterResource(R.drawable.antifragile)
//            Image(painter = image,
//                contentDescription = "Antifragile by LE SSERAFIM",
//                contentScale = ContentScale.Fit,
//                modifier = Modifier
//                    .aspectRatio(
//                        ratio = image.intrinsicSize.height /
//                                image.intrinsicSize.width
//                    )
//                    .fillMaxWidth()
//                    .padding(all = 30.dp)
//                    .shadow(
//                        elevation = 10.dp,
//                        shape = RectangleShape
//                    )
//                    .background(Color.White)
//                    .border(3.dp, Color.Gray, shape = RectangleShape)
//                    .padding(all = 25.dp)
//            )
//            Spacer(modifier = Modifier.height(90.dp))
//            Column(
//                modifier = Modifier
//                    .shadow(
//                        elevation = 6.dp,
//                        shape = RectangleShape
//                    )
//                    .background(color = Color.White)
//                    .border(1.dp, Color.Gray, shape = RectangleShape)
//                    .padding(top = 16.dp, bottom = 16.dp, start = 20.dp, end = 20.dp)
//            ) {
//                Text(text = "ANTIFRAGILE")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    buildAnnotatedString {
//                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
//                            append("LE SSERAFIM")
//                            append(" ")
//                        }
//                        append("(2023)")
//                    }
//                )
//            }
//
//            // DONT CHANGE!!!
//            Spacer(modifier = Modifier.height(70.dp))
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .size(48.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Button(
//                    onClick =
//                    {
//                        if (page == 1)
//                        {
//                            page = 5
//                        }
//                        else
//                        {
//                            page -= 1
//                        }
//                    },
//                    modifier = Modifier
//                        .padding(start = 40.dp)
//                        .height(44.dp)
//                        .width(130.dp),
//                    shape = RoundedCornerShape(6.dp),
//                    colors = ButtonDefaults.buttonColors(Color(90,75,160))
//                ) {
//                    Text(text = "Back", fontSize = 16.sp)
//                }
//                Spacer(modifier = Modifier.width(20.dp))
//                Button(
//                    onClick =
//                    {
//                        if (page == 5)
//                        {
//                            page = 1
//                        }
//                        else
//                        {
//                            page += 1
//                        }
//                    },
//                    modifier = Modifier
//                        .wrapContentWidth(align = Alignment.End)
//                        .padding(end = 40.dp)
//                        .height(44.dp)
//                        .width(130.dp),
//                    shape = RoundedCornerShape(6.dp),
//                    colors = ButtonDefaults.buttonColors(Color(90,75,160))
//                ) {
//                    Text(text = "Next", fontSize = 16.sp)
//                }
//            }
//            Spacer(modifier = Modifier.height(12.dp))
//        }
//        2 -> Column
//    }
//}