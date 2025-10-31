package com.example.adt_notes.data.models

import androidx.annotation.DrawableRes

data class BottomNavigationItemModel(
    val route: String,
    val name: String,
    @DrawableRes val icon: Int
)
