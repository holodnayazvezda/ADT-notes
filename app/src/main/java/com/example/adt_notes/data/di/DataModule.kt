package com.example.adt_notes.data.di

import com.example.adt_notes.data.network.api.ApiService
import com.example.adt_notes.data.network.repository.AuthRepositoryImpl
import com.example.adt_notes.data.storage.AppStorage
import com.example.adt_notes.data.storage.AuthStorage
import com.example.adt_notes.data.storage.Storage
import com.example.adt_notes.domain.repository.AuthRepository
import com.example.adt_notes.domain.usecase.LoginUsecase
import com.example.adt_notes.domain.usecase.RegistrationUsecase
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("http://45.151.30.221:1488/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

    single<AuthRepository> {
        AuthRepositoryImpl(api = get())
    }

    single {
        AuthStorage(context = get())
    }

    single {
        AppStorage(context = get())
    }
}
