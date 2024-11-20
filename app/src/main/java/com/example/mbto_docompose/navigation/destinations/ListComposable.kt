package com.example.mbto_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mbto_docompose.ui.screens.list.ListScreen
import com.example.mbto_docompose.ui.viewmodels.SharedViewModel
import com.example.mbto_docompose.util.Constants.LIST_ARGUMENT_KEY
import com.example.mbto_docompose.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    navigationToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            sharedViewModel = sharedViewModel,
            navigationToTaskScreen = navigationToTaskScreen
        )
    }
}