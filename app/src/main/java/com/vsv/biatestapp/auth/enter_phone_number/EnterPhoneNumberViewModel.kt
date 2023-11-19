package com.vsv.biatestapp.auth.enter_phone_number

import android.text.Editable
import com.vsv.biatestapp.base.BaseViewModel

class EnterPhoneNumberViewModel : BaseViewModel<EnterPhoneNumberState>(EnterPhoneNumberState()) {

    fun checkInput(text: Editable?) {
        if (text?.length == 10) {
            viewState = viewState.copy(isCorrectPhoneNumber = true)
        } else {
            viewState = viewState.copy(isCorrectPhoneNumber = false)
        }
    }


}