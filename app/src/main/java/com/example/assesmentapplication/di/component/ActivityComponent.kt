package com.example.assesmentapplication.di.component

import com.example.assesmentapplication.di.ActivityScope
import com.example.assesmentapplication.di.module.ActivityModule
import com.example.assesmentapplication.ui.MainActivity
import com.example.assesmentapplication.ui.moviedetails.MovieDetailsActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)

interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: MovieDetailsActivity)
}
