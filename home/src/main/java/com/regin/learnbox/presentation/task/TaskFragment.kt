package com.regin.learnbox.presentation.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.regin.learnbox.home.R
import com.regin.learnbox.presentation.base.BaseFragment
import com.regin.learnbox.util.extension.setSupportActionBar
import kotlinx.android.synthetic.main.activity_home.*

class TaskFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}