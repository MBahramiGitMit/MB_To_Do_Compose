package com.example.mbto_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mbto_docompose.navigation.destinations.listComposable
import com.example.mbto_docompose.navigation.destinations.taskComposable
import com.example.mbto_docompose.ui.viewmodels.SharedViewModel
import com.example.mbto_docompose.util.Action

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    val screens = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = "list/{${Action.NO_ACTION}}"
    ) {
        listComposable(
            navigationToTaskScreen = screens.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigationToListScreen = screens.list,
            sharedViewModel = sharedViewModel
        )
    }
}