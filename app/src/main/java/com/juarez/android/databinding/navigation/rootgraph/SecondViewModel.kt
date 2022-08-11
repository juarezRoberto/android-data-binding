package com.juarez.android.databinding.navigation.rootgraph

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private var _value = MutableLiveData(0)
    val value: LiveData<Int> = _value

    fun increment() {
        _value.value = (_value.value?.plus(1))
    }
}