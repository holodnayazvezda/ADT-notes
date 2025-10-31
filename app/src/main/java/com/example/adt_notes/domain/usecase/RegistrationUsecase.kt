package com.example.adt_notes.domain.usecase

import androidx.compose.ui.geometry.Rect
import com.example.adt_notes.data.network.dto.TokenPair
import com.example.adt_notes.data.states.RegistrationState
import com.example.adt_notes.domain.repository.AuthRepository

class RegistrationUsecase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        state: RegistrationState
    ): TokenPair {
        return repository.register(
            name = state.name,
            email = state.email,
            password = state.password,
            role = "USER"
        )
    }

    fun checkEmail(email: String): String {
        if (email.isEmpty()) {
            return "Email not specified"
        }

        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        if (!emailRegex.matches(email)) {
            return "Invalid email format"
        }

        return ""
    }


    fun checkName(name: String): String {
        return if (name.isEmpty()) {
            "Name not specified"
        } else {
            ""
        }
    }

    fun checkPassword(password: String): String {
        if (password.isEmpty()) {
            return "Password not specified"
        }
        if (password.length <= 8) {
            return "Password is too short"
        }
        if (!password.any { it.isUpperCase() }) {
            return "Password must contain at least one uppercase letter"
        }
        if (!password.any { it.isDigit() }) {
            return "Password must contain at least one digit"
        }
        if (!password.any { !it.isLetterOrDigit() }) {
            return "Password must contain at least one special character"
        }
        return ""
    }

    fun checkConfirmPassword(
        password: String,
        confirmPassword: String
    ): String {
        return if (password != confirmPassword) {
            "Passwords are not same"
        } else {
            ""
        }
    }
}