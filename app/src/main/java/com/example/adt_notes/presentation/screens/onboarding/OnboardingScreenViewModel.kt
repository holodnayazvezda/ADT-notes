package com.example.adt_notes.presentation.screens.onboarding

import com.example.adt_notes.R
import com.example.adt_notes.data.models.Onboarding

class OnboardingScreenViewModel {
    public val onboardingModel = listOf(
        Onboarding(
            imagesResId = R.drawable.onboarding_1,
            title = "Manage your\nnotes easily",
            comment = "A completely easy way to manage and customize\nyour notes."
        ),
        Onboarding(
            imagesResId = R.drawable.onboarding_2,
            title = "Organize your\nthougts",
            comment = "Most beautiful note taking application."
        ),
        Onboarding(
            imagesResId = R.drawable.onboarding_3,
            title = "Create cards and\neasy styling",
            comment = "Making your content legible has never been\neasier."
        )
    )
}