package com.example.mbto_docompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mbto_docompose.data.models.Priority
import com.example.mbto_docompose.ui.theme.LARGE_PADDING
import com.example.mbto_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.mbto_docompose.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Spacer(modifier = Modifier.width(LARGE_PADDING))
        Text(
            text = priority.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
fun PreviewPriorityItem() {
    PriorityItem(Priority.HIGH)
}