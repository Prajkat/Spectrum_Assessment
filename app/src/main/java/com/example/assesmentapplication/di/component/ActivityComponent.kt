package com.example.assesmentapplication.di.component

import com.example.assesmentapplication.ui.splash.SplashActivity
import com.example.assesmentapplication.di.ActivityScope
import com.example.assesmentapplication.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity: SplashActivity)
}
