package io.supercharge.hiltexample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.supercharge.hiltexample.main.ui.MainMenuFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindMainMenuFragment(): MainMenuFragment
}
