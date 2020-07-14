package io.supercharge.hiltexample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory
@Inject constructor(
    private val providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = providerMap[modelClass] ?: providerMap.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value
        ?: error("Can't find ViewModel to inject ($modelClass) - perhaps it's not added to ViewModelModule?")

        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: ClassCastException) {
            throw IllegalStateException("Something went terribly wrong while instantiating a ViewModel", e)
        }
    }
}
