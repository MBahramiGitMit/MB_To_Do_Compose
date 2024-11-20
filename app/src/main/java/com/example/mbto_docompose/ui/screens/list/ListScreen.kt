package com.example.mbto_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.mbto_docompose.R
import com.example.mbto_docompose.ui.theme.fabBackgroundColor
import com.example.mbto_docompose.ui.viewmodels.SharedViewModel
import com.example.mbto_docompose.util.SearchAppBarState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    sharedViewModel: SharedViewModel,
    navigationToTaskScreen: (taskId: Int) -> Unit
) {
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent()
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigationToTaskScreen)
        },
    )
}

@Composable
fun ListFab(onFabClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.fabBackgroundColor,
        onClick = { onFabClicked(-1) }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White

        )
    }
}