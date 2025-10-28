package com.example.adt_notes.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.adt_notes.data.states.LoginState
import com.example.adt_notes.domain.usecase.LoginUsecase

class LoginScreenViewModel(
    val loginUsecase: LoginUsecase = LoginUsecase()
): ViewModel() {
    private var _state by mutableStateOf(LoginState())
    val state
        get() = _state

    fun changeLogin(newLogin: String) {
        _state = _state.copy(login = newLogin)
    }

    fun changePassword(newPassword: String) {
        _state = _state.copy(password = newPassword)
    }

//    fun checkAndUpdateLoginState(
//        login: String,
//        password: String
//    ) {
//        val loginError = loginUsecase.checkLogin(login)
//        if (loginError.isNotEmpty()) {
//            state = state.copy(
//                isError = true,
//                errorString = loginError
//            )
//            return
//        }
//
//        val passwordError = loginUsecase.checkPassword(password)
//        if (passwordError.isNotEmpty()) {
//            state = state.copy(
//                isError = true,
//                errorString = passwordError
//            )
//            return
//        }
//
//        state = state.copy(
//            login = login,
//            password = password
//        )
//    }
}