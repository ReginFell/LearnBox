package com.regin.learnbox.presentation.base

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment<out T : BaseViewModel> : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorLiveData.observe(this, Observer { handleError(it) })
    }

    protected abstract val viewModel: T

    open fun handleError(throwable: Throwable?) {
        (activity as BaseActivity).handleError(throwable)
    }
}