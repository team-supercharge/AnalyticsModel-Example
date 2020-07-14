package io.supercharge.hiltexample.main.model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainMenuViewModel @ViewModelInject internal constructor() : ViewModel() {

    val textValue = MutableLiveData("Hilt")
}