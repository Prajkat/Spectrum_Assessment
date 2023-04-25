package com.example.assesmentapplication.di.component

import android.app.Application
import android.content.Context
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.di.ApplicationContext
import com.example.assesmentapplication.di.module.ApplicationModule
import com.example.assesmentapplication.di.module.NetworkModule
import com.example.assesmentapplication.model.service.MovieService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(app: MainApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getMovieApiServices(): MovieService
}
