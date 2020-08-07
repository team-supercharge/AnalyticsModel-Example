package io.supercharge.hiltexample.io.supercharge.hiltexample.analytics

import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Event
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Param

interface AnalyticsTracker {

    fun logEvent(event: Event, vararg params: Pair<Param, Any>)
}
