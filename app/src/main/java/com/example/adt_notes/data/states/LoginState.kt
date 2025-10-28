package com.example.adt_notes.data.states

data class LoginState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorString: String = ""
)
