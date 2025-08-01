package com.jahid.ar.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jahid.ar.ui.navigation.ObjectDetailsScreen
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DrillScreen(navController: NavController) {
    val listOfDrills = listOf(
        "cube",
        "cylinder",
        "Sphere"
    )
    Column {
        Box(modifier = Modifier.height(50.dp)) {
            Text(text = "Drills", fontSize = 24.sp, modifier = Modifier.align(Alignment.Center))
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(
                    state = rememberScrollState()
                ),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center
        ) {
            listOfDrills.forEach { drill ->
                DrillItem(drill = drill) {
                    navController.navigate(ObjectDetailsScreen(drill))
                }
            }
        }
    }
}

@Composable
fun DrillItem(drill: String, onClick: () -> Unit) {
    val color = remember(drill) {
        generateRandomLightColor()
    }
    Box(modifier = Modifier
        .padding(16.dp)
        .size(200.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(color)
        .clickable { onClick() }) {
        Text(
            text = drill,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center),
            color = Color.Black
        )
    }
}

fun generateRandomLightColor(): Color {
    val random = Random(System.currentTimeMillis())
    val red = random.nextInt(150, 256)
    val green = random.nextInt(200, 256)
    val blue = random.nextInt(200, 256)
    val color = Color(red, green, blue)
    return color
}

