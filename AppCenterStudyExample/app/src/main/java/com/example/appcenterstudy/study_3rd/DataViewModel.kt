package com.example.appcenterstudy.study_3rd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel() : ViewModel() {

    private val _count = MutableLiveData<Int>(0)
    val count : LiveData<Int>get() = _count

    fun addCount(){
        Log.d("TEST_FRAGMENT","Add Click")
        _count.value = _count.value?.plus(1)
    }

    fun minusCount(){
        Log.d("TEST_FRAGMENT","Minus Click")
        _count.value = _count.value?.minus(1)
    }

}