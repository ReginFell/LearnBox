package com.regin.learnbox.task.presentation.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.regin.learnbox.models.task.Task
import com.regin.learnbox.task.R
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.item_task.task_id as taskId
import kotlinx.android.synthetic.main.item_task.task_name as taskName

class TaskAdapter() : ListAdapter<Task, TaskAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(task: Task) {
            itemView.task_id.text = task.id
            itemView.task_name.text = task.name
        }
    }

}