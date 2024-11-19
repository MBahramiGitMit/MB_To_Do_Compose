package com.example.mbto_docompose.ui.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbto_docompose.R

@Composable
fun ListScreen(navigationToTaskScreen: (Int) -> Unit) {
    Scaffold(
        topBar = {
            ListAppBar()
        },
        content = { it },
        floatingActionButton = {
            ListFab(onFabClicked = navigationToTaskScreen)
        },
    )
}

@Composable
fun ListFab(onFabClicked: (Int) -> Unit) {
    FloatingActionButton(onClick = { onFabClicked(-1) }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White

        )
    }
}

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigationToTaskScreen = {})
}