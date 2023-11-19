package com.vsv.biatestapp.tasks.delegates

import androidx.recyclerview.widget.DiffUtil
import com.vsv.biatestapp.tasks.Task

class TaskDiffUtil: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.hasStatus == newItem.hasStatus
    }
}