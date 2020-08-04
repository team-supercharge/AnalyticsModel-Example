package io.supercharge.hiltexample.main.model

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainMenuViewModel @ViewModelInject internal constructor() : ViewModel() {

    private val _value = MutableLiveData(0)

    val value: LiveData<Int>
        get() = _value

    val incrementValue = View.OnClickListener {
        _value.postValue(_value.value!! + 1)
    }

    val decrementValue = View.OnClickListener {
        _value.postValue(_value.value!! - 1)
    }
}
