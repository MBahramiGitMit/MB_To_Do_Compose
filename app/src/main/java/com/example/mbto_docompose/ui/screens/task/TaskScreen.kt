package com.example.mbto_docompose.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.mbto_docompose.data.models.Priority
import com.example.mbto_docompose.data.models.ToDoTask
import com.example.mbto_docompose.ui.viewmodels.SharedViewModel
import com.example.mbto_docompose.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    val context = LocalContext.current
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    when (action) {
                        Action.NO_ACTION -> {
                            navigateToListScreen(action)
                        }

                        Action.DELETE -> {
                            navigateToListScreen(action)
                        }


                        else -> {
                            if (sharedViewModel.validateFields()) {
                                navigateToListScreen(action)
                            } else {
                                displayToast(context)
                            }
                        }
                    }
                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { sharedViewModel.onTitleChange(it) },
                description = description,
                onDescriptionChange = { sharedViewModel.description.value = it },
                priority = priority,
                onPriorityChange = { sharedViewModel.priority.value = it }
            )

        }
    )
}


fun displayToast(context: Context) {
    Toast.makeText(context, "Fields Empty!", Toast.LENGTH_SHORT).show()
}