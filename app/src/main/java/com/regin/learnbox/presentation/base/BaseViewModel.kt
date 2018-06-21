package com.regin.learnbox.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.regin.learnbox.models.core.Error

abstract class BaseViewModel : ViewModel() {

    val errorLiveData: MutableLiveData<Error> = MutableLiveData()
    val progressLiveData: MutableLiveData<Throwable> = MutableLiveData()

}