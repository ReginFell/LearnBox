package com.regin.learnbox.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.regin.learnbox.models.core.LocalError
import com.regin.learnbox.util.livedata.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    val localErrorLiveData: SingleLiveEvent<LocalError> = SingleLiveEvent()
    val progressLiveData: MutableLiveData<Throwable> = MutableLiveData()

}