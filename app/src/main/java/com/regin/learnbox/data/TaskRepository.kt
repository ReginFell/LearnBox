package com.regin.learnbox.data

import com.regin.learnbox.persistence.dao.TaskDao
import com.regin.learnbox.persistence.entity.Task
import com.regin.networking.api.Api

class TaskRepository(private val api: Api, private val taskDao: TaskDao) {

    private suspend fun getTasks() {
        api.getTasks().await()
                .map { Task(it.id, it.name) }
                .let { taskDao.insert(it) }
    }

    suspend fun listenTasks(): List<com.regin.learnbox.models.task.Task> {
        getTasks()
        return taskDao.getAll()
                .map { com.regin.learnbox.models.task.Task(it.id, it.name) }
    }
}