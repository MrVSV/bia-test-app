package com.vsv.biatestapp.tasks.presentation

import com.vsv.biatestapp.base.BaseViewModel
import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.model.Statistics
import com.vsv.biatestapp.tasks.model.StatusMark
import com.vsv.biatestapp.tasks.model.Task
import com.vsv.biatestapp.tasks.model.TaskListItem

class TaskListViewModel : BaseViewModel<TaskListState>(TaskListState(0, emptyList())) {

    private val taskList = listOf<TaskListItem>(
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
    private val historyList = listOf<TaskListItem>(
        Statistics(),
        Task(
            id = 10,
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
            id = 30,
            date = "10.08.2023",
            time = "(21:00 - 09:00)",
            shift = "Ночная смена",
            hasStatus = true,
            status = listOf("Ваш ответ принят", "Вам поступит подтверждение о выполнении задания"),
        ),
        Task(
            id = 50,
            date = "10.08.2023",
            time = "(21:00 - 09:00)",
            shift = "Ночная смена",
            hasStatus = true,
            status = listOf("Выполнение задания отклонено", "Вы отклонили задание для выполнения"),
            statusMark = StatusMark.BAD
        ),
        Task(
            id = 51,
            date = "10.08.2023",
            time = "(21:00 - 09:00)",
            shift = "Ночная смена",
            hasStatus = true,
            status = listOf("Выполнение задания отклонено", "Задание не актуально для выполнения"),
            statusMark = StatusMark.BAD
        ),

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
        newTaskList[index] = (newTaskList[index] as Task).copy(
            hasStatus = true,
            status = status,
            statusMark = statusMark
        )
        viewState = viewState.copy(taskList = newTaskList)
    }

    fun setTaskTab(position: Int) {
        when(position) {
            0 ->  viewState = viewState.copy(id = 0, taskList = taskList)
            1 ->  viewState = viewState.copy(id = 1, taskList = historyList)
        }
    }
}