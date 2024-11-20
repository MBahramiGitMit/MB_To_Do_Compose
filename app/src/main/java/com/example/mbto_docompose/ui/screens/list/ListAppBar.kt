package com.example.mbto_docompose.ui.screens.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbto_docompose.R
import com.example.mbto_docompose.components.PriorityItem
import com.example.mbto_docompose.data.models.Priority
import com.example.mbto_docompose.ui.theme.MEDIUM_PADDING
import com.example.mbto_docompose.ui.theme.TOP_APP_BAR_HEIGHT
import com.example.mbto_docompose.ui.theme.Typography
import com.example.mbto_docompose.ui.theme.topAppBarBackgroundColor
import com.example.mbto_docompose.ui.theme.topAppBarContentColor
import com.example.mbto_docompose.ui.viewmodels.SharedViewModel
import com.example.mbto_docompose.util.SearchAppBarState

@Composable
fun ListAppBar(
    sharedViewModel: SharedViewModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
) {
    when (searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchClicked = {
                    sharedViewModel.searchAppBarState.value = SearchAppBarState.OPENED
                },
                onSortClicked = {},
                onDeleteClicked = {}
            )
        }

        else -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = { newText ->
                    sharedViewModel.searchTextState.value = newText
                },
                onCloseClicked = {
                    sharedViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                },
                onSearchClicked = {})

        }
    }
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(onSortClicked: (Priority) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Filled.FilterList,
            contentDescription = stringResource(R.string.sort_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }) {

            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(Priority.LOW)
            }

            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            }) {
                PriorityItem(Priority.HIGH)
            }

            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            }) {
                PriorityItem(Priority.NONE)
            }
        }
    }
}

@Composable
fun DeleteAllAction(onDeleteClicked: () -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = stringResource(id = R.string.delete_all_actions),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClicked()
            }) {
                Text(
                    modifier = Modifier.padding(start = MEDIUM_PADDING),
                    text = stringResource(id = R.string.delete_all_actions),
                    style = Typography.subtitle2
                )
            }
        }
    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {
        val customTextSelectionColors = TextSelectionColors(
            handleColor = Color.Transparent,
            backgroundColor = Color.White.copy(alpha = ContentAlpha.disabled)
        )

        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = onTextChange,
                placeholder = {
                    Text(
                        modifier = Modifier.alpha(ContentAlpha.medium),
                        text = stringResource(id = R.string.search_placeholder),
                        color = Color.White
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                ),
                singleLine = true,
                leadingIcon = {
                    IconButton(
                        modifier = Modifier.alpha(ContentAlpha.disabled),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = stringResource(id = R.string.search_icon),
                            tint = MaterialTheme.colors.topAppBarContentColor
                        )
                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            if (text.isEmpty()) {
                                onCloseClicked()
                            } else {
                                onTextChange("")
                            }

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = stringResource(id = R.string.close_icon),
                            tint = MaterialTheme.colors.topAppBarContentColor
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onSearchClicked(text) }),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = MaterialTheme.colors.topAppBarContentColor,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
@Preview
fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
@Preview
fun SearchAppBarPreview() {
    SearchAppBar(text = "", onTextChange = {}, onCloseClicked = {}, onSearchClicked = {})
}