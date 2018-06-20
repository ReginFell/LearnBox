package com.regin.learnbox.task.presentation

import android.arch.lifecycle.MutableLiveData
import com.regin.learnbox.models.task.Task
import com.regin.learnbox.presentation.base.BaseViewModel
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.android.UI

class TaskViewModel(private val dispatcher: CoroutineDispatcher = UI) : BaseViewModel() {

    val taskLive: MutableLiveData<List<Task>> = MutableLiveData()

    init {
        taskLive.value = listOf()
    }

    public fun dod() {
        errorLiveData.value = Throwable("12345")
    }
}