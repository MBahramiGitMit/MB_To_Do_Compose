package com.example.mbto_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mbto_docompose.navigation.destinations.listComposable
import com.example.mbto_docompose.navigation.destinations.taskComposable
import com.example.mbto_docompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController
) {

    val screens = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigationToTaskScreen = screens.task)
        taskComposable(navigationToListScreen = screens.list)
    }
}