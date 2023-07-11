package com.flipbay.lamdacallbacks

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), DefaultLifecycleObserver {

    internal fun getCallbackAfterDelay(response: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            delay(2000)
            response("Time Up")
        }
    }
}