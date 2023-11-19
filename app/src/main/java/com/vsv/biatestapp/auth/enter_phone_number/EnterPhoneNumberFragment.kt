package com.vsv.biatestapp.auth.enter_phone_number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.vsv.biatestapp.base.BaseFragment
import com.vsv.biatestapp.databinding.FragmentEnterPhoneNumberBinding

class EnterPhoneNumberFragment : BaseFragment<FragmentEnterPhoneNumberBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentEnterPhoneNumberBinding? {
        return FragmentEnterPhoneNumberBinding.inflate(inflater)
    }

    private val viewModel = EnterPhoneNumberViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        flowObserver(viewModel.viewStates()) { state -> stateObserve(state) }
    }

    private fun stateObserve(state: EnterPhoneNumberState) {
        binding.continueBtn.isEnabled = state.isCorrectPhoneNumber
    }

    private fun setupViews() {
        binding.textInputLayout.requestFocus()
        binding.textInputLayout.editText?.doAfterTextChanged { text -> viewModel.checkInput(text) }
        binding.continueBtn.setOnClickListener {
            findNavController().navigate(EnterPhoneNumberFragmentDirections.actionEnterPhoneNumberFragmentToEnterCodeFragment())
        }
    }

}