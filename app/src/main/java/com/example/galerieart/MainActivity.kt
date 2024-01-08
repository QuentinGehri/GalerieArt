package com.example.galerieart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galerieart.ui.theme.GalerieArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalerieArtTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalerieArt()
                }
            }
        }
    }
}

@Composable
fun GalerieArt(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val element = retourneElement(result)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Row {
            Text(
                text = "Galerie D\'art",
                modifier = modifier,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Image(
                painter = painterResource(element.first),
                contentDescription = stringResource(element.second),
                )
        }
        Row {
            Text(
                text = stringResource(element.second),
                modifier = modifier
                    .padding(PaddingValues(bottom = 16.dp))
            )
        }
        Row {
            Button(onClick = {
                if (result == 1) {
                    result = 3
                } else {
                    result -= 1
                }
            }) {
                Text(
                    text = "Precedent",
                    modifier = modifier
                )
            }
            Button(onClick = {
                if (result == 3) {
                    result = 1
                } else {
                    result += 1
                }
            }) {
                Text(
                    text = "Suivant",
                    modifier = modifier
                )
            }
        }
    }
}

fun retourneElement(result : Int): Pair<Int, Int> {
    val image =  when (result) {
        1 -> R.drawable.lemon1 to R.string.verre
        2 -> R.drawable.lemon2 to R.string.citron
        else -> R.drawable.lemon3 to R.string.arbre
    }
    return image
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GalerieArtTheme {
        GalerieArt()
    }
}