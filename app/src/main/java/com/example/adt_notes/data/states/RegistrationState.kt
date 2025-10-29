package com.example.adt_notes.data.states

data class RegistrationState(
    val login: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorString: String = ""
)