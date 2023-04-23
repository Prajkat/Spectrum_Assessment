package com.example.assesmentapplication.di.module

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assesmentapplication.factory.ViewModelProviderFactory
import com.example.assesmentapplication.repository.MovieRepository
import com.example.assesmentapplication.ui.home.HomeViewModel
import com.example.assesmentapplication.ui.popular.PopularViewModel
import com.example.assesmentapplication.ui.toprated.TopRatedViewModel
import com.example.assesmentapplication.ui.upcoming.UpcomingViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    fun provideHomeViewModel(repository: MovieRepository): HomeViewModel {
        return ViewModelProvider(fragment,
            ViewModelProviderFactory(HomeViewModel::class) { HomeViewModel(repository) })[HomeViewModel::class.java]
    }

    @Provides
    fun providePopularViewModel(repository: MovieRepository): PopularViewModel {
        return ViewModelProvider(fragment,
            ViewModelProviderFactory(PopularViewModel::class) { PopularViewModel(repository) })[PopularViewModel::class.java]
    }

    @Provides
    fun provideTopRatedViewModel(repository: MovieRepository): TopRatedViewModel {
        return ViewModelProvider(fragment,
            ViewModelProviderFactory(TopRatedViewModel::class) { TopRatedViewModel(repository) })[TopRatedViewModel::class.java]
    }

    @Provides
    fun provideUpcomingViewModel(repository: MovieRepository): UpcomingViewModel {
        return ViewModelProvider(fragment,
            ViewModelProviderFactory(UpcomingViewModel::class) { UpcomingViewModel(repository) })[UpcomingViewModel::class.java]
    }
}