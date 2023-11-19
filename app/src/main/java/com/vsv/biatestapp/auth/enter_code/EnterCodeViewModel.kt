package com.vsv.biatestapp.auth.enter_code

import android.content.ContentValues.TAG
import android.util.Log
import com.vsv.biatestapp.base.BaseViewModel

class EnterCodeViewModel : BaseViewModel<EnterCodeState>(EnterCodeState()) {

    fun checkCode(code: String) {
        Log.d(TAG, "checkCode: $code")
        viewState = if (code == viewState.rightCode) viewState.copy(isCorrectCode = true)
        else viewState.copy(isCorrectCode = false)
    }
}
