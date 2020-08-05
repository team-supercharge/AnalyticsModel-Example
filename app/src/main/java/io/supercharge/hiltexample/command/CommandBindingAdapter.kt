package io.supercharge.hiltexample.io.supercharge.hiltexample.command

import android.view.View
import androidx.databinding.BindingAdapter
import io.supercharge.hiltexample.HiltApplication
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants

@BindingAdapter(value = ["command", "analyticsEvent"], requireAll = false)
fun View.bindAnalyticsCommandToButton(command: Command?, event: AnalyticsConstants.Event?) {
    setOnClickListener {
        command?.execute()

        event?.let {
            (context.applicationContext as HiltApplication?)?.tracker?.logEvent(event)
        }
    }
}
