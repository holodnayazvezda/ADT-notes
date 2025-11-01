package com.example.adt_notes.presentation.di

import com.example.adt_notes.presentation.screens.login.LoginScreenViewModel
import com.example.adt_notes.presentation.screens.register.RegisterScreenViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { (navigateToNextScreen: () -> Unit) ->
        RegisterScreenViewModel(
            registrationUsecase = get(),
            navigateToNextScreen = navigateToNextScreen
        )
    }

    factory { (navigateToNextScreen: () -> Unit) ->
        LoginScreenViewModel(
            loginUsecase = get(),
            navigateToNextScreen = navigateToNextScreen
        )
    }
}
