package com.example.assesmentapplication.model.service

import android.content.Context
import com.example.assesmentapplication.BuildConfig
import com.example.assesmentapplication.model.network.RequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object WebApiServicesProvider {

    fun createWebApiServices(context: Context): MovieService {
        val okHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
}