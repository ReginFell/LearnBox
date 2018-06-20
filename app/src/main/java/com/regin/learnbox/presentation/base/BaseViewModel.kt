package com.regin.learnbox.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    val progressLiveData: MutableLiveData<Throwable> = MutableLiveData()

}