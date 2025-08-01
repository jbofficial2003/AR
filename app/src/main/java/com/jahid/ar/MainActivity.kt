package com.jahid.ar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jahid.ar.ui.navigation.ARScreen
import com.jahid.ar.ui.navigation.DrillScreen
import com.jahid.ar.ui.navigation.ObjectDetailsScreen
import com.jahid.ar.ui.screen.ARScreen
import com.jahid.ar.ui.screen.ObjectDetailsScreen
import com.jahid.ar.ui.screen.DrillScreen
import com.jahid.ar.ui.theme.ARTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = DrillScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<ObjectDetailsScreen> {
                            val objectName = it.toRoute<ObjectDetailsScreen>().objectName
                            ObjectDetailsScreen(navController, objectName)
                        }
                        composable<ARScreen> {
                            val drill = it.toRoute<ARScreen>().model
                            ARScreen(navController,drill)
                        }
                        composable<DrillScreen> {
                            DrillScreen(navController)
                        }
                    }

                }
            }
        }
    }
}

