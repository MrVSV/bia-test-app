package com.vsv.biatestapp.tasks.delegates

import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.model.TaskListItem
import com.vsv.delegates.ListDelegateAdapter

class TaskAdapter(onClick: (OnTaskClick, Int) -> Unit): ListDelegateAdapter<TaskListItem>(TaskDiffUtil()) {

    init {
        addDelegate(taskDelegate(onClick))
        addDelegate(statisticsDelegate())
    }
}