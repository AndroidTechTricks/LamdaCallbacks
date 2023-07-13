package com.flipbay.lamdacallbacks

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel: ViewModel(), DefaultLifecycleObserver {

    internal fun getCallbackAfterDelay(response: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            delay(2000)
            response("Time Up")
        }
    }

    internal fun getTwoParamsInCallback(response: (String,Int) -> Unit) {
        if(Random.nextInt().mod(2) == 0) {
            response("Even",1)
        } else {
            response("Odd",2)
        }
    }

    internal fun returnValueOfMethod(response: (Int) -> Int): Int {
        return response(5)
    }
}