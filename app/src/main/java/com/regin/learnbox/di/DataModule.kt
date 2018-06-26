package com.regin.learnbox.di

import com.regin.learnbox.data.TaskRepository
import org.koin.dsl.module.applicationContext

val dataModule = applicationContext {
    bean { TaskRepository(get(), get()) }
}
