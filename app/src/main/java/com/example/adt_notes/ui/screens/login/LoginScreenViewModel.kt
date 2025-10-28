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

    fun changeState(
        login: String = state.login,
        password: String = state.password,
        isError: Boolean = state.isError,
        errorString: String = state.errorString
    ) {
        _state = _state.copy(
            login = login,
            password = password,
            isError = isError,
            errorString = errorString
        )
    }

    fun buttonNextPressed() {
        checkLogin()
        if (!state.isError) checkPassword()
        if (!state.isError) {
//            TODO: отравить запрос на проверку данных на сервер и выполнить вход
        }
    }

    private fun checkPassword() {
        val passwordError = loginUsecase.checkPassword(state.password)
        if (passwordError.isNotEmpty()) {
            _state = _state.copy(
                isError = true,
                errorString = passwordError
            )
        }
    }

    private fun checkLogin() {
        val loginError = loginUsecase.checkLogin(state.login)
        if (loginError.isNotEmpty()) {
            _state = _state.copy(
                isError = true,
                errorString = loginError
            )
        }
    }
}