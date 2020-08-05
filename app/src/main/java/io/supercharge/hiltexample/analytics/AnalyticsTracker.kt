package io.supercharge.hiltexample.io.supercharge.hiltexample.analytics

import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Event

interface AnalyticsTracker {

    fun logEvent(event: Event)
}
