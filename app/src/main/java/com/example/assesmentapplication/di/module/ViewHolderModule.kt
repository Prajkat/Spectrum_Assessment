package com.example.assesmentapplication.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.assesmentapplication.di.ViewModelScope
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule() {

      @Provides
      @ViewModelScope
      fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry()
}