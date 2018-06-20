package com.regin.learnbox.presentation.splash

import com.regin.learnbox.presentation.navigation.HOME_SCREEN
import com.regin.learnbox.presentation.base.BaseViewModel
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import ru.terrakok.cicerone.Router

class SplashViewModel(private val router: Router,
                      private val dispatcher: CoroutineDispatcher = UI) : BaseViewModel() {

    private var splashJob: Job? = null

    companion object {
        private const val SPLASH_DURATION = 1
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