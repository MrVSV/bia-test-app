package com.vsv.biatestapp.auth.enter_code

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.vsv.biatestapp.base.BaseFragment
import com.vsv.biatestapp.databinding.FragmentEnterCodeBinding


class EnterCodeFragment : BaseFragment<FragmentEnterCodeBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentEnterCodeBinding? {
        return FragmentEnterCodeBinding.inflate(inflater)
    }

    private val viewModel: EnterCodeViewModel = EnterCodeViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        flowObserver(viewModel.viewStates()) { state -> stateObserve(state) }

    }

    private fun stateObserve(state: EnterCodeState) {
        binding.continueBtn.isEnabled = state.isCorrectCode
    }

    private fun setupViews() {
        Toast.makeText(requireContext(), "123456", Toast.LENGTH_LONG).show()

        var code = ""
        binding.code1.requestFocus()
        binding.code1.doAfterTextChanged { text ->
            code += text.toString()
            binding.code2.requestFocus()
        }
        binding.code2.doAfterTextChanged { text ->
            code += text.toString()
            binding.code3.requestFocus()
        }
        binding.code3.doAfterTextChanged { text ->
            code += text.toString()
            binding.code4.requestFocus()
        }
        binding.code4.doAfterTextChanged { text ->
            code += text.toString()
            binding.code5.requestFocus()
        }
        binding.code5.doAfterTextChanged { text ->
            code += text.toString()
            binding.code6.requestFocus()
        }
        binding.code6.doAfterTextChanged { text ->
            code += text.toString()
            viewModel.checkCode(code)
        }

        binding.backToPhone.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.continueBtn.setOnClickListener {
            findNavController().navigate(EnterCodeFragmentDirections.actionEnterCodeFragmentToTaskNavGraph())
        }
    }
}