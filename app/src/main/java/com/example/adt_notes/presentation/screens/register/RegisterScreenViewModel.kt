package com.example.adt_notes.presentation.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adt_notes.data.states.RegistrationState
import com.example.adt_notes.data.storage.AuthStorage
import com.example.adt_notes.domain.usecase.RegistrationUsecase
import kotlinx.coroutines.launch

class RegisterScreenViewModel(
    val authStorage: AuthStorage,
    val registrationUsecase: RegistrationUsecase,
    val navigateToNextScreen: () -> Unit
) : ViewModel() {
    private var _state by mutableStateOf(RegistrationState())
    val state
        get() = _state

    fun changeState(
        name: String = state.name,
        email: String = state.email,
        password: String = state.password,
        confirmPassword: String = state.confirmPassword,
        isLoading: Boolean = state.isLoading,
        isError: Boolean = state.isError,
        errorString: String = state.errorString
    ) {
        _state = _state.copy(
            name = name,
            email = email,
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
            changeState(isLoading = true)
            viewModelScope.launch {
                try {
                    val tokenPair = registrationUsecase.invoke(state)
                    authStorage.accessToken = tokenPair.accessToken
                    navigateToNextScreen()
                    changeState(isLoading = false)
                } catch (e: Exception) {
                    changeState(
                        isLoading = false,
                        isError = true,
                        errorString = e.message ?: "Unknown error"
                    )
                }
            }
        }
    }

    private fun checkOnErrors() {
        val nameError = registrationUsecase.checkName(state.name)
        val loginError = registrationUsecase.checkEmail(state.email)
        val passwordError = registrationUsecase.checkPassword(state.password)
        val confirmPasswordError = registrationUsecase.checkConfirmPassword(
            state.password,
            state.confirmPassword
        )
        val errorString = nameError.ifEmpty {
            loginError.ifEmpty {
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