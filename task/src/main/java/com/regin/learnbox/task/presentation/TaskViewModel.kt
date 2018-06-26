package com.regin.learnbox.task.presentation

import android.arch.lifecycle.MutableLiveData
import com.regin.learnbox.data.TaskRepository
import com.regin.learnbox.models.core.LocalError
import com.regin.learnbox.models.task.Task
import com.regin.learnbox.presentation.base.BaseViewModel
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class TaskViewModel(private val dispatcher: CoroutineDispatcher = UI,
                    private val taskRepository: TaskRepository) : BaseViewModel() {

    val taskLive: MutableLiveData<List<Task>> = MutableLiveData()

    init {
        dod()
    }

    private fun dod() {
        launch {
            try {
                val tasks = taskRepository.getTasks().await()
            } catch (e: Exception) {
                withContext(dispatcher) {
                    localErrorLiveData.value = LocalError(e) { dod() }
                }
            }
        }
    }
}