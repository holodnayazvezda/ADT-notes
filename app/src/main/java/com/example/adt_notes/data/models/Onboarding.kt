package com.example.adt_notes.data.models

import androidx.annotation.DrawableRes

data class Onboarding(
    @param:DrawableRes val imagesResId: Int,
    val title: String,
    val comment: String
)
