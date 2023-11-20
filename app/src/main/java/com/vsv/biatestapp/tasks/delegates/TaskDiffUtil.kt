package com.vsv.biatestapp.tasks.delegates

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.vsv.biatestapp.tasks.model.TaskListItem

class TaskDiffUtil: DiffUtil.ItemCallback<TaskListItem>() {
    override fun areItemsTheSame(oldItem: TaskListItem, newItem: TaskListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TaskListItem, newItem: TaskListItem): Boolean {
        return oldItem.id == newItem.id
    }
}