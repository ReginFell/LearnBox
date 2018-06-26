package com.regin.learnbox.task.presentation.adapter

import android.support.v7.util.DiffUtil
import com.regin.learnbox.models.task.Task

class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(p0: Task, p1: Task) = p0.id == p1.id

    override fun areContentsTheSame(p0: Task, p1: Task) = p0 == p1

}