package io.supercharge.hiltexample.io.supercharge.hiltexample.analytics

import android.util.Log
import javax.inject.Inject

class DefaultAnalyticsTracker @Inject constructor() : AnalyticsTracker {

    override fun logEvent(
        event: AnalyticsConstants.Event,
        vararg params: Pair<AnalyticsConstants.Param, Any>
    ) {
        Log.i("AnalyticsLog", "Event: $event, Params: ${params.toList()}")
    }
}
