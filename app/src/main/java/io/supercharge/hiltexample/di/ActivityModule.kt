package io.supercharge.hiltexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.supercharge.hiltexample.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
