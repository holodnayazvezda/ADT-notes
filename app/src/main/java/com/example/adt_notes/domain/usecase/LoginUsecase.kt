package com.example.adt_notes.domain.usecase

class LoginUsecase(

) {
    fun checkLogin(login: String): String {
        return if (login.isEmpty()) {
            "Login not specified"
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