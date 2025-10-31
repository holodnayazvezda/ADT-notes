package com.example.adt_notes.domain.usecase

class LoginUsecase(

) {
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