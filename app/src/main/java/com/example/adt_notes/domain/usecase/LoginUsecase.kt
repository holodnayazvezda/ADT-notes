package com.example.adt_notes.domain.usecase

import com.example.adt_notes.data.network.dto.TokenPair
import com.example.adt_notes.data.states.LoginState
import com.example.adt_notes.data.states.RegistrationState
import com.example.adt_notes.domain.repository.AuthRepository

class LoginUsecase(
//    private val repository: AuthRepository
) {
//    suspend operator fun invoke(
//        state: LoginState
//    ): TokenPair {
//        return repository.authenticate(
//            email = state.email,
//            password = state.password,
//        )
//    }

    fun checkEmail(email: String): String {
        return if (email.isEmpty()) {
            "Email not specified"
        } else {
            ""
        }
    }

    fun checkPassword(password: String): String {
        return if (password.isEmpty()) {
            "Password not specified"
        } else {
            ""
        }
    }
}