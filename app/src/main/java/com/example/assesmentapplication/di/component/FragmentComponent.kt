package com.example.assesmentapplication.di.component

import com.example.assesmentapplication.di.FragmentScope
import com.example.assesmentapplication.di.module.FragmentModule
import dagger.Component


@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {
}
