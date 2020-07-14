package io.supercharge.hiltexample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.supercharge.hiltexample.di.qualifier.ViewModelKey
import io.supercharge.hiltexample.main.model.MainMenuViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainMenuViewModel::class)
    abstract fun provideMainMenuViewModel(viewModel: MainMenuViewModel): ViewModel
}
