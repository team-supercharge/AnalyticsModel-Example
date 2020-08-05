package io.supercharge.hiltexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsTracker
import javax.inject.Inject

@HiltAndroidApp
class HiltApplication : Application() {

    @Inject
    lateinit var tracker: AnalyticsTracker

    override fun onCreate() {
        super.onCreate()
    }
}
