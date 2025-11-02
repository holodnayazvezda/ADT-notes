package com.example.adt_notes.data.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.adt_notes.data.navigation.NotesRoutes

data class NotesType(
    val route: NotesRoutes,
    val name: String,
    val accentColor: Color,
    @DrawableRes val iconResId: Int
)