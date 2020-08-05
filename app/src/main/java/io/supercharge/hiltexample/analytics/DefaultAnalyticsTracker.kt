package io.supercharge.hiltexample.io.supercharge.hiltexample.analytics

import android.util.Log
import javax.inject.Inject

class DefaultAnalyticsTracker @Inject constructor() : AnalyticsTracker {

    override fun logEvent(
        event: AnalyticsConstants.Event
    ) {
        Log.i("AnalyticsLog", "Event: $event")
    }
}
