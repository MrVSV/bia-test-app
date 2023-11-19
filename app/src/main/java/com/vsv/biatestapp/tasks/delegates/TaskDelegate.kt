package com.vsv.biatestapp.tasks.delegates

import android.view.LayoutInflater
import android.view.View
import com.vsv.biatestapp.R
import com.vsv.biatestapp.databinding.TaskViewHolderBinding
import com.vsv.biatestapp.tasks.OnTaskClick
import com.vsv.biatestapp.tasks.StatusMark
import com.vsv.biatestapp.tasks.Task
import com.vsv.delegates.adapterDelegate

fun taskDelegate(
    onClick: (OnTaskClick, Int) -> Unit,
) = adapterDelegate<Task, Task, TaskViewHolderBinding>({ parent ->
    TaskViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
}) {
    binding.confirmBtn.setOnClickListener {
        onClick(OnTaskClick.CONFIRM, bindingAdapterPosition)
    }
    binding.dismissBtn.setOnClickListener {
        onClick(OnTaskClick.DISMISS, bindingAdapterPosition)
    }
    bind {
        binding.name.text = item.name
        binding.date.text = "${item.date}*${item.time}"
        binding.destination.text = item.destination
        binding.shift.text = item.shift
        binding.speciality.text = item.speciality
        binding.actionLayout.visibility = if (item.hasStatus) View.GONE else View.VISIBLE
        binding.statusLayout.visibility = if (item.hasStatus) View.VISIBLE else View.GONE
        binding.status.apply {
            text = item.status[0]
            setTextColor(
                resources.getColor(
                    when (item.statusMark) {
                        StatusMark.GOOD -> R.color.green
                        StatusMark.BAD -> R.color.red
                        StatusMark.NEUTRAL -> R.color.black
                    }
                )
            )
        }
        binding.statusDescription.text = item.status[1]


    }
}