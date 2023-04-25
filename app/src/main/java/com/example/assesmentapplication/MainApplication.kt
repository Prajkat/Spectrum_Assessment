package com.example.assesmentapplication

import android.app.Application
import com.example.assesmentapplication.di.component.ApplicationComponent
import com.example.assesmentapplication.di.component.DaggerApplicationComponent
import com.example.assesmentapplication.di.module.ApplicationModule
import com.example.assesmentapplication.di.module.NetworkModule

class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule(this))
            .build()
        applicationComponent.inject(this)
    }
}