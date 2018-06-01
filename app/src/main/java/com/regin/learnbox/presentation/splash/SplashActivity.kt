package com.regin.learnbox.presentation.splash

import android.os.Bundle
import com.regin.learnbox.presentation.base.BaseActivity
import org.koin.android.architecture.ext.getViewModel
import org.koin.standalone.StandAloneContext.loadKoinModules

class SplashActivity : BaseActivity() {

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(splashModule)

        splashViewModel = getViewModel()
    }
}