package io.supercharge.hiltexample.main.model

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsConstants.Event
import io.supercharge.hiltexample.io.supercharge.hiltexample.analytics.AnalyticsTracker

class CounterViewModel @ViewModelInject internal constructor(
    private val tracker: AnalyticsTracker
) : ViewModel() {

    private val _value = MutableLiveData(0)

    val value: LiveData<Int>
        get() = _value

    val incrementValue = View.OnClickListener {
        tracker.logEvent(Event.INCREMENT_CLICKED)
        _value.postValue(_value.value!! + 1)
    }

    val decrementValue = View.OnClickListener {
        tracker.logEvent(Event.DECREMENT_CLICKED)
        _value.postValue(_value.value!! - 1)
    }
}
