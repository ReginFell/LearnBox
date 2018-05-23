package com.regin.learnbox.splash

import com.regin.learnbox.presentation.HOME_SCREEN
import com.regin.learnbox.presentation.base.BaseViewModel
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import ru.terrakok.cicerone.Router

class SplashViewModel(private val router: Router,
                      private val dispatcher: CoroutineDispatcher = UI) : BaseViewModel() {

    private var splashJob: Job? = null

    companion object {
        private const val SPLASH_DURATION = 2000L
    }

    fun start() {
        launch {
            delay(SPLASH_DURATION)

            launch(dispatcher) {
                router.navigateTo(HOME_SCREEN)
            }
        }
    }

    override fun onCleared() {
        splashJob?.cancel()
    }
}