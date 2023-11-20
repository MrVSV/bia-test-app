package com.vsv.biatestapp.tasks.presentation

import android.content.ContentValues.TAG
import android.util.Log
import com.vsv.biatestapp.tasks.model.Task
import com.vsv.biatestapp.tasks.model.TaskListItem

data class TaskListState(
    val id: Int = 0,
    val taskList: List<TaskListItem>,
){
    init {
        Log.d(TAG, "task: ")
    }
}
