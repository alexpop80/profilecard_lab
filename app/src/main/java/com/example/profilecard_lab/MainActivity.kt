package com.example.profilecard_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard_lab.ui.theme.Profilecard_labTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Profilecard_labTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    profilecard(
                        name = "Alexander Escobar",
                        modifier = Modifier.padding(innerPadding)

                    )

                }
            }
        }
    }
}

// all that profile does is get the profile picture and make its circle shape
@Composable
fun profile( modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.catfishproflie)
    Box() {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(200.dp)
                .clip(CircleShape),


        )

    }
}

//bio is all of the text that the app use come form
@Composable
fun bio(name: String, modifier: Modifier = Modifier) {
    Row {
        Column{
            Text(
                name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontSize =  (30.sp),
                //this center the profile name
                textAlign = TextAlign.Center
            )
            Text(
                text = "I am 21 year old and about to be 22 at the end March but my goal in life is make something people can have fun with.",
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

// this the composable that put the other two together and center it and space all the element by 8.dp
@Composable
fun profilecard(name: String , modifier: Modifier = Modifier){
    //this change the background color
    Surface(color = Color(116,219,176)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = modifier.padding(16.dp)
                .fillMaxSize()
        ) {
            profile()
            bio("Alexander Escobar")
        }
    }
}

// this is just a Preview
@Preview(showBackground = true)
@Composable
fun profilePreview() {
    Profilecard_labTheme {
        profilecard("done")
    }
}
