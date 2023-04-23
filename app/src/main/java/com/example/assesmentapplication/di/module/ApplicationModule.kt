package com.example.assesmentapplication.di.module

import android.app.Application
import android.content.Context
import com.example.assesmentapplication.BuildConfig
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.di.ApplicationContext
import com.example.assesmentapplication.model.network.Networking
import com.example.assesmentapplication.model.service.MovieService
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MainApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    fun provideNetworkService(): MovieService =
        Networking.create(
            BuildConfig.API_KEY,
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024
        ) // 10MB

}