package com.example.assesmentapplication.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.assesmentapplication.di.ActivityContext
import com.example.assesmentapplication.factory.ViewModelProviderFactory
import com.example.assesmentapplication.repository.MovieRepository
import com.example.assesmentapplication.ui.moviedetails.MovieDetailsViewModel
import dagger.Module
import dagger.Provides

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideMovieDetailsViewModel(repository: MovieRepository): MovieDetailsViewModel =
        ViewModelProviders.of(
            activity, ViewModelProviderFactory(MovieDetailsViewModel::class) {
                MovieDetailsViewModel(repository)
                //this lambda creates and return SplashViewModel
            }).get(MovieDetailsViewModel::class.java)

}
