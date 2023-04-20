package com.example.assesmentapplication.di.module

import com.example.assesmentapplication.ui.base.BaseActivity
import dagger.Module

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity) {

}
