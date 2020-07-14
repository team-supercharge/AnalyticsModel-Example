package io.supercharge.hiltexample.main.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainMenuViewModel @Inject internal constructor() : ViewModel() {

    val textValue = MutableLiveData("Hilt")
}