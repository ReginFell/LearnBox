package com.regin.learnbox.task.presentation

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val taskModule = applicationContext {
    viewModel { TaskViewModel() }
}
