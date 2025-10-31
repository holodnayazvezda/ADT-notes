package com.example.adt_notes.data.network.repository

import com.example.adt_notes.data.network.api.ApiService
import com.example.adt_notes.data.network.dto.AuthRequestDto
import com.example.adt_notes.data.network.dto.RegisterRequestDto
import com.example.adt_notes.data.network.dto.TokenPair
import com.example.adt_notes.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: ApiService
) : AuthRepository {
    override suspend fun register(
        email: String,
        password: String,
        role: String
    ): TokenPair {
        return api.register(
            RegisterRequestDto(
                email = email,
                password = password,
                role = role
            )
        )
    }

    override suspend fun authenticate(
        email: String,
        password: String
    ): TokenPair {
        return api.authenticate(
            AuthRequestDto(
                email = email,
                password = password
            )
        )
    }
}