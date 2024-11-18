package com.example.mbto_docompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.mbto_docompose.ui.theme.HighPriorityColor
import com.example.mbto_docompose.ui.theme.LowPriorityColor
import com.example.mbto_docompose.ui.theme.MediumPriorityColor
import com.example.mbto_docompose.ui.theme.NonePriorityColor

enum class Priority(val color:Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}