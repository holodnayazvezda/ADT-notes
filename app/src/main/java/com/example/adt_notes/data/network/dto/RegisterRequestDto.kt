package com.example.adt_notes.data.network.dto

data class RegisterRequestDto(
    val name: String,
    val email: String,
    val password: String,
    val role: String = "USER"
)
