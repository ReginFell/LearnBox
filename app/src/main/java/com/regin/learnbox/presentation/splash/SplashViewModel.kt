package com.regin.learnbox.presentation.splash

import com.regin.learnbox.presentation.HOME_SCREEN
import com.regin.learnbox.presentation.base.BaseViewModel
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import ru.terrakok.cicerone.Router

class SplashViewModel(private val router: Router,
                      private val dispatcher: CoroutineDispatcher = UI) : BaseViewModel() {

    private var splashJob: Job? = null

    companion object {
        private const val SPLASH_DURATION = 2000L
    }

    init {
        launch {
            delay(SPLASH_DURATION)

            withContext(dispatcher) {
                router.navigateTo(HOME_SCREEN)
            }
        }
    }

    override fun onCleared() {
        splashJob?.cancel()
    }
}