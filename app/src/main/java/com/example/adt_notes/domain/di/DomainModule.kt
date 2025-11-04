package com.example.adt_notes.domain.di

import com.example.adt_notes.domain.usecase.LoginUsecase
import com.example.adt_notes.domain.usecase.RegistrationUsecase
import com.example.adt_notes.domain.usecase.SplashScreenUsecase
import org.koin.dsl.module

val domainModule = module {
    factory {
        RegistrationUsecase(repository = get())
    }

    factory {
        LoginUsecase(repository = get())
    }

    factory {
        SplashScreenUsecase(repository = get())
    }
}
