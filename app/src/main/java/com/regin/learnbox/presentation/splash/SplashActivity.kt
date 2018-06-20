package com.regin.learnbox.presentation.splash

import android.os.Bundle
import android.view.View
import com.regin.learnbox.R
import com.regin.learnbox.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.architecture.ext.getViewModel
import org.koin.standalone.StandAloneContext.loadKoinModules

class SplashActivity : BaseActivity() {

    override val containerView: View by lazy { container }

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadKoinModules(splashModule)

        splashViewModel = getViewModel()
    }
}