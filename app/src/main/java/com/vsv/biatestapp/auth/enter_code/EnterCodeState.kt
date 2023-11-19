package com.vsv.biatestapp.auth.enter_code

data class EnterCodeState(
    val isCorrectCode: Boolean = false,
    val rightCode: String = "123456"
)