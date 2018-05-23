package com.regin.learnbox.di

import com.regin.learnbox.Application
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {
    bean { Application.getRouter() }
}
