package com.regin.learnbox.task.presentation

import android.arch.lifecycle.MutableLiveData
import com.regin.learnbox.models.core.LocalError
import com.regin.learnbox.models.task.Task
import com.regin.learnbox.presentation.base.BaseViewModel
import com.regin.networking.api.Api
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class TaskViewModel(private val dispatcher: CoroutineDispatcher = UI,
                    private val api: Api) : BaseViewModel() {

    val taskLive: MutableLiveData<List<Task>> = MutableLiveData()

    init {
        taskLive.value = listOf()
    }

    fun dod() {
        launch {
            try {
                val tasks = api.getTasks().await()
            } catch (e: Exception) {
                withContext(dispatcher) {
                    localErrorLiveData.value = LocalError(e) { dod() }
                }
            }
        }
    }
}