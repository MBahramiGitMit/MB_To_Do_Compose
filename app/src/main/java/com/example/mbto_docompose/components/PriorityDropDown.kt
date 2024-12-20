package com.example.mbto_docompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mbto_docompose.R
import com.example.mbto_docompose.data.models.Priority
import com.example.mbto_docompose.ui.theme.PRIORITY_DROP_DOWN_HEIGHT
import com.example.mbto_docompose.ui.theme.PRIORITY_INDICATOR_SIZE

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = stringResource(id = R.string.drop_down_arrow_anim)
    )

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(PRIORITY_DROP_DOWN_HEIGHT)
        .background(MaterialTheme.colors.background)
        .clickable { expanded = true }
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
            shape = MaterialTheme.shapes.small
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(PRIORITY_INDICATOR_SIZE)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.subtitle1
        )
        Icon(
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate(angle)
                .weight(1.5f),
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = stringResource(id = R.string.drop_down_arrow)
        )
    }
    Box {
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(fraction = 0.94f),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = false
                onPrioritySelected(Priority.LOW)
            }) {
                PriorityItem(Priority.LOW)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onPrioritySelected(Priority.MEDIUM)
            }) {
                PriorityItem(Priority.MEDIUM)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onPrioritySelected(Priority.HIGH)
            }) {
                PriorityItem(Priority.HIGH)
            }
        }
    }
}


@Composable
@Preview
fun PreviewPriorityDropDown() {
    PriorityDropDown(Priority.HIGH) { }
}