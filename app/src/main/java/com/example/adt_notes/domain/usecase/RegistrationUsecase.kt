package com.example.adt_notes.domain.usecase

class RegistrationUsecase(

) {
    fun checkLogin(login: String): String {
        if (login.isEmpty()) {
            return "Login not specified"
        } else if (login.length <= 3) {
            return "Login is to short"
        }
        return ""
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