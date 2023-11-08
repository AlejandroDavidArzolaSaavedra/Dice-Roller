package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme
import com.example.diceroller.ui.theme.redP
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var rotationState by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Roller-Up",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )

        Box(
            modifier = Modifier
                .graphicsLayer(rotationZ = rotationState)
                .clip(MaterialTheme.shapes.medium)
                .clickable {
                    result = Random.nextInt(1, 7)
                    rotationState += 360f 
                }
        ) {
            val animatedRotationState by animateFloatAsState(
                targetValue = rotationState,
                animationSpec = tween(durationMillis = 1000)
            )

            Image(
                painter = painterResource(id = getDrawableForDice(result)),
                contentDescription = result.toString(),
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer(rotationZ = animatedRotationState)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result = Random.nextInt(1, 7)
                rotationState += 360f
            },
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(redP)
        ) {
            Text(
                text = stringResource(id = R.string.roll),
                fontSize = 32.sp,
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }
    }
}

fun getDrawableForDice(diceNumber: Int): Int {
    return when (diceNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
