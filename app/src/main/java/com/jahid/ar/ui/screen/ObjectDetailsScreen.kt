package com.jahid.ar.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jahid.ar.R
import com.jahid.ar.ui.navigation.ARScreen

@Composable
fun ObjectDetailsScreen(navController: NavController, objectName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = getObjectImage(objectName)),
                    contentDescription = "$objectName image",
                    modifier = Modifier.size(120.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = objectName.capitalize(),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = getObjectDescription(objectName),
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { navController.navigate(ARScreen(objectName)) }
                ) {
                    Text(text = "Start AR Drill")
                }
            }
        }
    }
}

private fun getObjectDescription(objectName: String): String {
    return when (objectName.lowercase()) {
        "cube" -> "A cube is a three-dimensional solid object bounded by six square faces, facets or sides, with three meeting at each vertex. It has 6 faces, 12 edges, and 8 vertices."
        "cylinder" -> "A cylinder is a three-dimensional solid that holds two parallel bases joined by a curved surface, at a fixed distance. It has 2 faces, 2 edges, and 0 vertices."
        "sphere" -> "A sphere is a perfectly round three-dimensional object where every point on the surface is equidistant from the center. It has 1 face, 0 edges, and 0 vertices."
        else -> "This is a 3D object that you can view in augmented reality."
    }
}

private fun getObjectImage(objectName: String): Int {
    return when (objectName.lowercase()) {
        "cube" -> R.drawable.ic_cube
        "cylinder" -> R.drawable.ic_cylinder
        "sphere" -> R.drawable.ic_sphere
        else -> R.drawable.ic_cube // default fallback
    }
}

private fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}