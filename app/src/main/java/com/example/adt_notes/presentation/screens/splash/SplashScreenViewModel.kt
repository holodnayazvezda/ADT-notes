package com.example.adt_notes.presentation.screens.splash

import androidx.lifecycle.ViewModel
import com.example.adt_notes.data.models.Onboarding
import com.example.adt_notes.data.storage.AuthStorage

class SplashScreenViewModel(
    val authStorage: AuthStorage,
    val navigateToOnboarding: () -> Unit,
    val navigateToLogin: () -> Unit
) : ViewModel() {
    fun navigateToNextScreen() {
        if (authStorage.watchedOnboarding) {
            navigateToLogin()
        } else {
            navigateToOnboarding()
        }
    }
}