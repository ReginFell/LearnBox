package com.regin.learnbox.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.regin.learnbox.models.core.LocalError

abstract class BaseViewModel : ViewModel() {

    val localErrorLiveData: MutableLiveData<LocalError> = MutableLiveData()
    val progressLiveData: MutableLiveData<Throwable> = MutableLiveData()

}