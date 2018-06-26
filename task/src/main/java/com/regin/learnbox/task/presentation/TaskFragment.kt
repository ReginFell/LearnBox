package com.regin.learnbox.task.presentation

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.regin.learnbox.presentation.base.BaseFragment
import com.regin.learnbox.task.R
import com.regin.learnbox.task.presentation.adapter.TaskAdapter
import kotlinx.android.synthetic.main.fragment_task.*
import kotlinx.android.synthetic.main.fragment_task.empty_state as emptyState
import org.koin.android.architecture.ext.getViewModel
import org.koin.standalone.StandAloneContext.loadKoinModules

class TaskFragment : BaseFragment<TaskViewModel>() {

    override lateinit var viewModel: TaskViewModel

    private val taskAdapter: TaskAdapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(taskModule)

        viewModel = getViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasks.adapter = taskAdapter

        viewModel.taskLive.observe(this, Observer {
            it?.also {
                if (it.isEmpty()) {
                    emptyState.visibility = View.VISIBLE
                } else {
                    taskAdapter.submitList(it)
                    emptyState.visibility = View.GONE
                }
            }
        })
    }
}