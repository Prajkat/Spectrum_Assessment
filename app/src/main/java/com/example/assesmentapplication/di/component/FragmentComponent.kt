package com.example.assesmentapplication.di.component

import com.example.assesmentapplication.di.FragmentScope
import com.example.assesmentapplication.di.module.FragmentModule
import com.example.assesmentapplication.ui.MainActivity
import com.example.assesmentapplication.ui.home.HomeFragment
import com.example.assesmentapplication.ui.popular.PopularFragment
import com.example.assesmentapplication.ui.toprated.TopRatedFragment
import com.example.assesmentapplication.ui.upcoming.UpcomingFragment
import dagger.Component


@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {
    fun inject(fragHomeFragment: HomeFragment)
    fun inject(fragPopularFragment: PopularFragment)
    fun inject(fragTopRatedFragment: TopRatedFragment)
    fun inject(fragUpcomingFragment: UpcomingFragment)
}
