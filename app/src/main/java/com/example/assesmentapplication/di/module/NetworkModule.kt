package com.example.assesmentapplication.di.module

import com.example.assesmentapplication.BuildConfig
import com.example.assesmentapplication.model.network.RequestInterceptor
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(RequestInterceptor())
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      //.addCallAdapterFactory(Coroutin.create())
      .build()
  }

}
