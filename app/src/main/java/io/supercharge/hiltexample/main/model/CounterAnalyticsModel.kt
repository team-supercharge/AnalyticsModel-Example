package io.supercharge.hiltexample.io.supercharge.hiltexample.main.model

import androidx.lifecycle.viewModelScope
import io.supercharge.hiltexample.analytics.AnalyticsModel
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Event
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Param
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsTracker
import io.supercharge.hiltexample.main.model.CounterViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class CounterAnalyticsModel @Inject constructor(
    private val analyticsTracker: AnalyticsTracker
) : AnalyticsModel<CounterViewModel>() {

    override fun onScreenViewModelAttached() {
        viewModel.viewModelScope.launch {
            flowOf(
                viewModel.decrementValue
                    .getExecutedEvents()
                    .onEach {
                        analyticsTracker.logEvent(
                            Event.DECREMENT_CLICKED,
                            Param.VALUE to viewModel.value.value!!
                        )
                    },
                viewModel.incrementValue
                    .getExecutedEvents()
                    .onEach {
                        analyticsTracker.logEvent(
                            Event.INCREMENT_CLICKED,
                            Param.VALUE to viewModel.value.value!!
                        )
                    }
            ).flattenMerge()
                .collect()
        }
    }
}
