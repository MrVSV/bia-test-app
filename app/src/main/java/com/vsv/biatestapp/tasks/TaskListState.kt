package com.vsv.biatestapp.tasks

import android.content.ContentValues.TAG
import android.util.Log

data class TaskListState(
    val taskList: List<Task>,
){
    init {
        Log.d(TAG, "task: ")
    }
}
