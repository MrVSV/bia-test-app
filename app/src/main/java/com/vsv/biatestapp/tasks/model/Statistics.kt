package com.vsv.biatestapp.tasks.model

data class Statistics(
    override val id: Int = 1000,
    val tasksCount: Int = 0,
    val tasksCompleted: Int = 0,
    val employeesSelected: Int = 0,
    val tasksDismissed: Int = 0
): TaskListItem
