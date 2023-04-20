package com.example.assesmentapplication.di.component

import com.amansaxena.nyt.di.module.ViewHolderModule
import com.example.assesmentapplication.di.ViewModelScope
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {
}
