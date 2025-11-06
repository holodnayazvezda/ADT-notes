package com.example.adt_notes.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adt_notes.data.storage.AppStorage
import com.example.adt_notes.data.storage.AuthStorage
import com.example.adt_notes.domain.usecase.SplashScreenUsecase
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    val splashScreenUsecase: SplashScreenUsecase,
    val authStorage: AuthStorage,
    val appStorage: AppStorage,
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
                        appStorage.userName = userModel.name
                        appStorage.userEmail = userModel.email
                        appStorage.userRole = userModel.role
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