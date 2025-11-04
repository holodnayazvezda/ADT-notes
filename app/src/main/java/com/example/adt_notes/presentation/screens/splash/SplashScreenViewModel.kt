package com.example.adt_notes.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adt_notes.data.models.Onboarding
import com.example.adt_notes.data.storage.AuthStorage
import com.example.adt_notes.domain.usecase.SplashScreenUsecase
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    val splashScreenUsecase: SplashScreenUsecase,
    val authStorage: AuthStorage,
    val navigateToOnboarding: () -> Unit,
    val navigateToLogin: () -> Unit,
    val navigateToRegistration: () -> Unit,
    val navigateToMain: () -> Unit
) : ViewModel() {
    fun navigateToNextScreen() {
        if (authStorage.watchedOnboarding) {
            if (authStorage.accessToken != null) {
                viewModelScope.launch {
                    try {
                        val userModel = splashScreenUsecase.invoke(
                            authStorage.accessToken!!
                        )
                        navigateToMain()
                    } catch (e: Exception) {
                        navigateToLogin()
                    }
                }
            } else {
                navigateToRegistration()
            }
        } else {
            navigateToOnboarding()
        }
    }
}