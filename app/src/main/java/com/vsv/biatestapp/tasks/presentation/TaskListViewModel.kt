package com.vsv.biatestapp.tasks.presentation

import com.vsv.biatestapp.base.BaseViewModel
import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.StatusMark
import com.vsv.biatestapp.tasks.Task
import com.vsv.biatestapp.tasks.TaskListState

class TaskListViewModel : BaseViewModel<TaskListState>(TaskListState(emptyList())) {

    val taskList = listOf<Task>(
        Task(
            id = 1,
            name = "Сборка",
            date = "11.08.2023",
            time = "(21:00 - 09:00)",
            destination = "Москва-Север-1",
            shift = "Ночная смена",
            speciality = "Сборщик",
            hasStatus = true,
            status = listOf("Работа по заданию подтверждена", "Ждем выхода на смену!"),
            statusMark = StatusMark.GOOD
        ),
        Task(
            id = 2,
            date = "11.08.2023",
            time = "(09:00 - 21:00)",
            shift = "Дневная смена",
            status = listOf("Выполнение задания отклонено", "Вы отклонили задание для выполнения"),
            statusMark = StatusMark.BAD
        ),
        Task(
            id = 3,
            date = "10.08.2023",
            time = "(21:00 - 09:00)",
            shift = "Ночная смена",
            hasStatus = true,
            status = listOf("Ваш ответ принят", "Вам поступит подтверждение о выполнении задания"),
        ),
        Task(
            id = 4,
            date = "10.08.2023",
            time = "(21:00 - 09:00)",
            shift = "Ночная смена",
            status = listOf("", ""),
        )
    )

    init {
        viewState = viewState.copy(
            taskList = taskList
        )
    }

    fun onClick(onTaskClick: OnTaskClick, index: Int) {

        var status = emptyList<String>()
        var statusMark = StatusMark.NEUTRAL
        when (onTaskClick) {
            OnTaskClick.CONFIRM -> {
                status =
                    listOf("Работа по заданию подтверждена", "Ждем выхода на смену!")
                statusMark = StatusMark.GOOD
            }
            OnTaskClick.DISMISS -> {
                status =
                    listOf("Выполнение задания отклонено", "Вы отклонили задание для выполнения")
                statusMark = StatusMark.BAD
            }
        }
        val newTaskList = viewState.taskList.toMutableList()
        newTaskList[index] = newTaskList[index].copy(
            hasStatus = true,
            status = status,
            statusMark = statusMark
        )
        viewState = viewState.copy(taskList = newTaskList)
    }
}