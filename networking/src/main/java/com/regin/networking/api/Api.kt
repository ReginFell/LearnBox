package com.regin.networking.api

import com.regin.networking.models.Task
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface Api {

    @GET("/tasks.json")
    fun getTasks(): Deferred<List<Task>>

}