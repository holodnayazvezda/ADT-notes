package com.example.adt_notes.data.states

data class RegistrationState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorString: String = ""
)