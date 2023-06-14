package com.example.artspaceapp

import android.graphics.Color.rgb
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SpaceArtGallery()
                }
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

class Info(
    val title: String = "TITLE",
    val author: String = "AUTHOR",
    val date: String = "1/1/2003"
)

@Composable
fun SpaceArtGallery(
    modifier: Modifier = Modifier,
) {
    val image = R.drawable.jeremy_thomas_e0ahdsenmdg_unsplash
    val imgs = listOf(
        R.drawable.jeremy_thomas_e0ahdsenmdg_unsplash,
        R.drawable.robots_1_by_hgjart_d2e61iq
    )
    val info = listOf(
        Info("I miss you", "Tran Dai Nien", "6/3/2003"),
        Info("I miss you too", "Nguyen Thi My Kim", "2/3/2003")
    )
    var current_index by remember { mutableStateOf(0) }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Surface(
            shadowElevation = 12.dp,
            shape = RoundedCornerShape(20.dp),
        ) {
           Image(
               painter = painterResource(imgs[current_index]),
               contentDescription = null,
               modifier = Modifier
//                   .width(300.dp)
                   .height(500.dp)
           )
        }

        Column() {
            Column(
                modifier = Modifier
                    .background(
                        color = Color(
                            color = rgb(230, 243, 244)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = info[current_index].title,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row() {
                    Text(
                        text = info[current_index].author,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "(" + info[current_index].date + ")"
                    )
                }
            }
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        current_index -= 1
                        if (current_index > 1) current_index = 0
                    },
                    modifier = Modifier
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(rgb(228, 254, 194)),
                        contentColor = Color.Black
                    )

                ) {
                    Text(
                        text = "Prev"
                    )
                }
                Button(
                    onClick = {
                        current_index += 1
                        if (current_index > 1) current_index = 0
                    },
                    modifier = Modifier
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(rgb(228, 254, 194)),
                        contentColor = Color.Black
                    )

                ) {
                    Text(
                        text = "Next",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        SpaceArtGallery()
    }
}