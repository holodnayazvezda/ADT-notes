package com.example.adt_notes.presentation.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.adt_notes.data.states.RegistrationState
import com.example.adt_notes.domain.usecase.RegistrationUsecase

class RegisterScreenViewModel(
    val registrationUsecase: RegistrationUsecase = RegistrationUsecase(),
    val navigateToNextScreen: () -> Unit
) : ViewModel() {
    private var _state by mutableStateOf(RegistrationState())
    val state
        get() = _state

    fun changeState(
        login: String = state.login,
        name: String = state.name,
        password: String = state.password,
        confirmPassword: String = state.confirmPassword,
        isLoading: Boolean = state.isLoading,
        isError: Boolean = state.isError,
        errorString: String = state.errorString
    ) {
        _state = _state.copy(
            login = login,
            name = name,
            password = password,
            confirmPassword = confirmPassword,
            isLoading = isLoading,
            isError = isError,
            errorString = errorString
        )
    }

    fun buttonNextPressed() {
        checkOnErrors()
        if (!state.isError) {
//            TODO: отравить запрос на проверку данных на сервер и выполнить вход
            navigateToNextScreen()
        }
    }

    private fun checkOnErrors() {
        val loginError = registrationUsecase.checkLogin(state.login)
        val nameError = registrationUsecase.checkName(state.name)
        val passwordError = registrationUsecase.checkPassword(state.password)
        val confirmPasswordError = registrationUsecase.checkConfirmPassword(
            state.password,
            state.confirmPassword
        )
        val errorString = loginError.ifEmpty {
            nameError.ifEmpty {
                passwordError.ifEmpty {
                    confirmPasswordError.ifEmpty { "" }
                }
            }
        }
        if (errorString.isNotEmpty()) {
            _state = _state.copy(
                isError = true,
                errorString = errorString
            )
        }
    }
}