package com.example.mbto_docompose.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbto_docompose.R
import com.example.mbto_docompose.ui.theme.fabBackgroundColor

@Composable
fun ListScreen(navigationToTaskScreen: (taskId: Int) -> Unit) {
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

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigationToTaskScreen = {})
}