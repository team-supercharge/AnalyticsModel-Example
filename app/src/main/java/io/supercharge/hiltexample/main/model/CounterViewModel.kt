package io.supercharge.hiltexample.main.model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Event
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsTracker
import io.supercharge.hiltexample.io.supercharge.hiltexample.command.FunctionCommand

class CounterViewModel @ViewModelInject internal constructor(
    private val tracker: AnalyticsTracker
) : ViewModel() {

    private val _value = MutableLiveData(0)

    val value: LiveData<Int>
        get() = _value

    val incrementValue = FunctionCommand {
        tracker.logEvent(Event.INCREMENT_CLICKED)
        _value.postValue(_value.value!! + 1)
    }

    val decrementValue = FunctionCommand {
        tracker.logEvent(Event.DECREMENT_CLICKED)
        _value.postValue(_value.value!! - 1)
    }
}
