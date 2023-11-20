package com.vsv.biatestapp.tasks.model

data class Task(
    override val id: Int,
    val name: String = "Сборка",
    val date: String,
    val time: String,
    val destination: String = "Москва-Север-1",
    val shift: String,
    val speciality: String = "Сборщик",
    val hasStatus: Boolean = false,
    val status: List<String>,
    val statusMark: StatusMark = StatusMark.NEUTRAL
): TaskListItem
