package com.example.adt_notes.domain.di

import com.example.adt_notes.domain.usecase.LoginUsecase
import com.example.adt_notes.domain.usecase.RegistrationUsecase
import org.koin.dsl.module

val domainModule = module {
    factory {
        RegistrationUsecase(get())
    }

}
