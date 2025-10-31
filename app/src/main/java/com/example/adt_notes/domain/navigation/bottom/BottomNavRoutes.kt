package com.example.adt_notes.domain.navigation.bottom

enum class BottomNavRoutes(
    val route: String
) {
    NOTES(route = "notes"),
    CREATE_NOTE(route = "create_note"),
    PROFILE(route = "profile")
}