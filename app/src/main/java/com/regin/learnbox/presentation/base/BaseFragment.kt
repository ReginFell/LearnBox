package com.regin.learnbox.presentation.base

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.regin.learnbox.models.core.LocalError

abstract class BaseFragment<out T : BaseViewModel> : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.localErrorLiveData.observe(this, Observer { handleError(it) })
    }

    protected abstract val viewModel: T

    open fun handleError(localError: LocalError?) {
        localError?.run {
            (activity as BaseActivity).handleError(this)
        }
    }
}