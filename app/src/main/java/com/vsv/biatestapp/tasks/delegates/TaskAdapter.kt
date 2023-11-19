package com.vsv.biatestapp.tasks.delegates

import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.Task
import com.vsv.delegates.ListDelegateAdapter

class TaskAdapter(onClick: (OnTaskClick, Int) -> Unit): ListDelegateAdapter<Task>(TaskDiffUtil()) {

    init {
        addDelegate(taskDelegate(onClick))
    }
}