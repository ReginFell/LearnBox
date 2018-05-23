package com.regin.learnbox.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.regin.learnbox.presentation.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.standalone.StandAloneContext.loadKoinModules

class SplashFragment : BaseFragment() {

    private val splashViewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(splashModule)

        splashViewModel.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}
