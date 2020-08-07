package io.supercharge.hiltexample.io.supercharge.hiltexample.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import io.supercharge.hiltexample.analytics.AnalyticsModel
import io.supercharge.hiltexample.analytics.AnalyticsModelProvider
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsTracker
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.DefaultAnalyticsTracker
import io.supercharge.hiltexample.io.supercharge.hiltexample.di.qualifier.AnalyticsModelKey
import io.supercharge.hiltexample.io.supercharge.hiltexample.main.model.CounterAnalyticsModel
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsTracker(tracker: DefaultAnalyticsTracker): AnalyticsTracker

    @Binds
    @IntoMap
    @AnalyticsModelKey(CounterAnalyticsModel::class)
    internal abstract fun provideDashboardScreenAnalyticsModel(
        analyticsModel: CounterAnalyticsModel
    ): AnalyticsModel<*>

    companion object {
        @Provides
        @Singleton
        internal fun provideAnalyticsModelProvider(
            analyticsModelMap: Map<Class<out AnalyticsModel<*>>, @JvmSuppressWildcards Provider<AnalyticsModel<*>>>
        ): AnalyticsModelProvider = AnalyticsModelProvider(analyticsModelMap)
    }
}
