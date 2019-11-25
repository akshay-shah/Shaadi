package com.akshay.shaadi.presentation.di

import android.content.Context
import com.akshay.shaadi.presentation.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Component(
    modules = [AndroidInjectionModule::class, ActivityBindingModule::class,
        ApiModule::class
        ,DataBaseModule::class,UseCaseModule::class]
)
interface AppComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Context): Builder

        fun build(): AppComponent
    }
}