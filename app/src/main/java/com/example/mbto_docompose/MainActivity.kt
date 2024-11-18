package com.example.mbto_docompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mbto_docompose.navigation.SetupNavigation
import com.example.mbto_docompose.ui.theme.MBToDoComposeTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBToDoComposeTheme {
                navController= rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}
