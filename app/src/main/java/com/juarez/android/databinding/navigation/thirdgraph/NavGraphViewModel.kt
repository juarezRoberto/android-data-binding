package com.juarez.android.databinding.navigation.thirdgraph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavGraphViewModel : ViewModel() {

    private var _value = MutableLiveData(0)
    val value: LiveData<Int> = _value

    fun increment() {
        _value.value = (_value.value?.plus(1))
    }
}