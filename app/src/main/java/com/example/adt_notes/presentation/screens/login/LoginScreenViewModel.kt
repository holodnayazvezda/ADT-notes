package com.example.adt_notes.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.adt_notes.data.states.LoginState
import com.example.adt_notes.data.storage.AuthStorage
import com.example.adt_notes.domain.usecase.LoginUsecase
import kotlinx.coroutines.launch
import kotlin.text.ifEmpty

class LoginScreenViewModel(
    val authStorage: AuthStorage,
    val loginUsecase: LoginUsecase,
    val navigateToNextScreen: () -> Unit
): ViewModel(), ViewModelProvider.Factory {
    private var _state by mutableStateOf(LoginState())
    val state
        get() = _state

    fun changeState(
        email: String = state.email,
        password: String = state.password,
        isLoading: Boolean = state.isLoading,
        isError: Boolean = state.isError,
        errorString: String = state.errorString
    ) {
        _state = _state.copy(
            email = email,
            password = password,
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
                    val tokenPair = loginUsecase.invoke(state)
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
        val emailError = loginUsecase.checkEmail(state.email)
        val passwordError = loginUsecase.checkPassword(state.password)
        val errorString = emailError.ifEmpty {
            passwordError.ifEmpty { "" }
        }

        if (errorString.isNotEmpty()) {
            _state = _state.copy(
                isError = true,
                errorString = errorString
            )
        }
    }
}