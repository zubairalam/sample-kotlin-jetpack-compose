package com.devhustlers.eduone.ui.utils

import androidx.compose.ui.graphics.Color

data class ProblemSummary(
    val id: String,
    val level: String,
    val topic: String,
    val title: String,
    val description: String,
    val backgroundColor: Color,
    val contentColor: Color,
    val timeBackgroundColor: Color,
    val detail: String,
    val solution: String,
)
