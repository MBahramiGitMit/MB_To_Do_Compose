package com.example.mbto_docompose.navigation

import androidx.navigation.NavHostController
import com.example.mbto_docompose.util.Action
import com.example.mbto_docompose.util.Constants

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(Constants.LIST_SCREEN) {
                inclusive = true
            }
        }
    }

    val task: (Int) -> Unit = {taskId->
        navController.navigate("task/${taskId}")
    }
}