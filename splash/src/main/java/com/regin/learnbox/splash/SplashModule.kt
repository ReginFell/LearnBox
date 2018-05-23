package com.regin.learnbox.splash

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val splashModule = applicationContext {
    viewModel { SplashViewModel(get()) }
}
