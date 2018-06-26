package com.regin.learnbox.task.presentation

import android.arch.lifecycle.MutableLiveData
import com.regin.learnbox.data.TaskRepository
import com.regin.learnbox.models.core.LocalError
import com.regin.learnbox.models.core.State
import com.regin.learnbox.presentation.base.BaseViewModel
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class TaskViewModel(private val dispatcher: CoroutineDispatcher = UI,
                    private val taskRepository: TaskRepository) : BaseViewModel() {

    val taskState: MutableLiveData<State> = MutableLiveData()

    init {
        init()
    }

    private fun init() {
        taskState.value = State.Loading()

        launch {
            try {
                val tasks = taskRepository.listenTasks()
                withContext(dispatcher) {
                    if (tasks.isEmpty()) {
                        taskState.value = State.Empty()
                    } else {
                        taskState.value = State.Content(tasks)
                    }
                }
            } catch (e: Exception) {
                withContext(dispatcher) {
                    localErrorLiveData.value = LocalError(e) { init() }
                }
            }
        }
    }
}