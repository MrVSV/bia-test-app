package com.vsv.biatestapp.tasks.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.tabs.TabLayout
import com.vsv.biatestapp.base.BaseFragment
import com.vsv.biatestapp.databinding.FragmentTaskListBinding
import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.delegates.TaskAdapter

class TaskListFragment : BaseFragment<FragmentTaskListBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentTaskListBinding? {
        return FragmentTaskListBinding.inflate(inflater)
    }

    private val viewModel: TaskListViewModel = TaskListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TaskAdapter(::onClick)
        setupViews(adapter)
        flowObserver(viewModel.viewStates()) { state -> stateObserve(state, adapter) }
    }

    private fun setupViews(adapter: TaskAdapter) {
        binding.recycle.adapter = adapter
        binding.tab.setSelectedTabListener { position ->
            viewModel.setTaskTab(position)

        }
    }

    private fun stateObserve(state: TaskListState, adapter: TaskAdapter) {
        adapter.submitList(state.taskList)
    }

    private fun onClick(onTaskClick: OnTaskClick, index: Int) {
        viewModel.onClick(onTaskClick, index)
    }

}


fun TabLayout.setSelectedTabListener(block: (position: Int) -> Unit){
    this.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            if (tab != null) { block(tab.position) }
        }
        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    })
}