package com.regin.learnbox.data

import com.regin.learnbox.persistence.dao.TaskDao
import com.regin.learnbox.persistence.entity.Task
import com.regin.networking.api.Api
import kotlinx.coroutines.experimental.reactive.awaitFirst

class TaskRepository(private val api: Api, private val taskDao: TaskDao) {

    fun getTasks() = api.getTasks()

    suspend fun listenTasks(): List<Task> {
        return taskDao.getAll().awaitFirst()
    }
}