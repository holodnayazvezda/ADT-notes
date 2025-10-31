package com.example.adt_notes

import com.example.adt_notes.data.di.dataModule
import com.example.adt_notes.domain.di.domainModule
import com.example.adt_notes.ui.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }
    }
}