package com.example.adt_notes.presentation.di

import com.example.adt_notes.presentation.screens.login.LoginScreenViewModel
import com.example.adt_notes.presentation.screens.main.botttom_navigation.notes.NotesScreenViewModel
import com.example.adt_notes.presentation.screens.onboarding.OnboardingScreenViewModel
import com.example.adt_notes.presentation.screens.register.RegisterScreenViewModel
import com.example.adt_notes.presentation.screens.splash.SplashScreenViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { (navigateToOnboarding: () -> Unit, navigateToLogin: () -> Unit) ->
        SplashScreenViewModel(
            authStorage = get(),
            navigateToOnboarding = navigateToOnboarding,
            navigateToLogin = navigateToLogin
        )
    }

    factory {
        OnboardingScreenViewModel(authStorage = get())
    }

    factory { (navigateToNextScreen: () -> Unit) ->
        RegisterScreenViewModel(
            authStorage = get(),
            registrationUsecase = get(),
            navigateToNextScreen = navigateToNextScreen
        )
    }

    factory { (navigateToNextScreen: () -> Unit) ->
        LoginScreenViewModel(
            authStorage = get(),
            loginUsecase = get(),
            navigateToNextScreen = navigateToNextScreen
        )
    }

    factory {
        NotesScreenViewModel()
    }
}
