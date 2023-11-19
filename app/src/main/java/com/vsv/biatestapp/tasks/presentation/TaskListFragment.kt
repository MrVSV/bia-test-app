package com.vsv.biatestapp.tasks.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.vsv.biatestapp.base.BaseFragment
import com.vsv.biatestapp.databinding.FragmentTaskListBinding
import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.TaskListState
import com.vsv.biatestapp.tasks.delegates.TaskAdapter

class TaskListFragment : BaseFragment<FragmentTaskListBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentTaskListBinding? {
        return FragmentTaskListBinding.inflate(inflater)
    }

    private val viewModel: TaskListViewModel = TaskListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TaskAdapter(::onClick)
        binding.recycle.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserve(state, adapter) }
    }

    private fun stateObserve(state: TaskListState, adapter: TaskAdapter) {

        adapter.submitList(state.taskList)
    }

    private fun onClick(onTaskClick: OnTaskClick, index: Int) {
        viewModel.onClick(onTaskClick, index)
    }

}