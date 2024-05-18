package com.example.copyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.copyapp.ui.theme.CopyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CopyAppTheme {
                MessageCard()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MessageCard() {
    val burgers = listOf(
        Burger("베이컨 토마토 디럭스", R.drawable.ic_launcher_background, 7400, 5800),
        Burger("맥 크리스피 버거", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("맥 크리스피 클래식", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("맥 치킨 모짜렐라", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("맥 치킨", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("더블 불고기", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("에그 불고기", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("불고기 버거", R.drawable.ic_launcher_background, 6000, 4500),
        Burger("맥 치킨", R.drawable.ic_launcher_background, 6000, 4500)

    )

    val burgersPerRow = 4  // 한 줄에 표시할 햄버거 개수
    val groupedBurgers = burgers.chunked(burgersPerRow)

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth())
    {
        for (group in groupedBurgers) {
            Row {
                for (burger in group) {
                    BurgerCard(burger)
                }
            }
            Divider(thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CopyAppTheme {
        MessageCard()
    }
}



data class Burger(
    val name: String,
    val imageResourceId: Int,  // Use resource ID for image instead of drawable directly
    val largePrice: Int,
    val smallPrice: Int
)

@Composable
fun BurgerCard(burger: Burger) {
    Column(
        modifier = Modifier
            .width(96.dp)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = burger.imageResourceId),
            contentDescription = "",
        )
        Text(text = burger.name, fontSize = 8.sp, fontWeight = FontWeight.Bold)
        Row {
            Text(text = "${burger.largePrice}", fontSize = 8.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "${burger.smallPrice}", fontSize = 8.sp, fontWeight = FontWeight.Bold)
        }
    }
}

//    Column(modifier = Modifier.fillMaxHeight()) {
//        for (burger in burgers) {
//            Row {
//                for (i in 1..4) {
//                    BurgerCard(burger = burger)
//                }
//            }
//        }
//    }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//        ) {
//            BurgerCard(paintid = R.drawable.ic_launcher_background , burgerName = "베이컨 토마토 디럭스", largePrice = 7400, smallPrice = 5800 )
//            BurgerCard(paintid = R.drawable.ic_launcher_background , burgerName = "더블 불고기 버거", largePrice = 6000, smallPrice = 4500 )
//            BurgerCard(paintid = R.drawable.ic_launcher_background , burgerName = "에그 불고기", largePrice = 6000, smallPrice = 4500 )
//            BurgerCard(paintid = R.drawable.ic_launcher_background , burgerName = "불고기 보고", largePrice = 6000, smallPrice = 4500 )
//
//            Divider(thickness = 1.dp)
//        }
