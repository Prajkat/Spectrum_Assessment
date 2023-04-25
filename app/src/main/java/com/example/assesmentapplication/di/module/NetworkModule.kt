package com.example.assesmentapplication.di.module

import android.content.Context
import com.example.assesmentapplication.model.service.MovieService
import com.example.assesmentapplication.model.service.WebApiServicesProvider
import dagger.Module
import dagger.Provides

@Module
class NetworkModule(private val context: Context) {

    @Provides
    fun provideWebApiServices(): MovieService =
        WebApiServicesProvider.createWebApiServices(context)
}
