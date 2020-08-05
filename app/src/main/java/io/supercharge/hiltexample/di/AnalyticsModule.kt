package io.supercharge.hiltexample.io.supercharge.hiltexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsTracker
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.DefaultAnalyticsTracker

@Module
@InstallIn(ApplicationComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsTracker(tracker: DefaultAnalyticsTracker): AnalyticsTracker
}
