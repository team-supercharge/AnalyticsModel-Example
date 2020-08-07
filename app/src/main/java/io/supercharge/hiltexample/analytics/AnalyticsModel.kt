package io.supercharge.hiltexample.analytics

import androidx.lifecycle.ViewModel

abstract class AnalyticsModel<T : ViewModel> {

    protected lateinit var viewModel: T

    fun getScreenViewModel(): T = viewModel

    fun setScreenViewModel(model: T) {
        viewModel = model
        onScreenViewModelAttached()
    }

    protected open fun onScreenViewModelAttached() {
        // Hook method
    }
}
