package com.example.mbto_docompose.ui.screens.list

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.mbto_docompose.data.models.Priority
import com.example.mbto_docompose.data.models.ToDoTask
import com.example.mbto_docompose.ui.theme.LARGE_PADDING
import com.example.mbto_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.mbto_docompose.ui.theme.TASK_ITEM_ELEVATION
import com.example.mbto_docompose.ui.theme.taskItemBackgroundColor
import com.example.mbto_docompose.ui.theme.taskItemTextColor

@Composable
fun ListContent() {


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = { navigateToTaskScreen(toDoTask.id) }
    ) {

        Column(
            modifier = Modifier
                .padding(LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
                    drawCircle(color = toDoTask.priority.color)
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}

@Composable
@Preview()
fun PreviewTaskItem() {
    TaskItem(
        ToDoTask(
            id = 10,
            title = "title",
            description = "hello my name is mehdi bahrami.hello my name is mehdi bahrami.hello my name is mehdi bahrami.hello my name is mehdi bahrami.",
            priority = Priority.HIGH
        )
    ) { }
}