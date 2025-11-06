package com.example.adt_notes.data.storage

import android.content.Context

private const val SharedPreferenceName = "app_preferences"
private const val UserName = "name"
private const val UserEmail = "email"
private const val UserRole = "role"



class AppStorage(context: Context): Storage(context, SharedPreferenceName) {
    var userName: String?
        get() = getString(UserName)
        set(value) = putString(UserName, value)

    var userEmail: String?
        get() = getString(UserEmail)
        set(value) = putString(UserEmail, value)

    var userRole: String?
        get() = getString(UserRole)
        set(value) = putString(UserRole, value)
}