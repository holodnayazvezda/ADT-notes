package com.example.adt_notes.data.network.repository

import com.example.adt_notes.data.network.api.ApiService
import com.example.adt_notes.data.network.dto.AuthRequestDto
import com.example.adt_notes.data.network.dto.RegisterRequestDto
import com.example.adt_notes.data.network.dto.TokenPair
import com.example.adt_notes.data.network.errors.NetworkErrorHandler
import com.example.adt_notes.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: ApiService
) : AuthRepository {
    override suspend fun register(
        name: String,
        email: String,
        password: String,
        role: String
    ): TokenPair {
        return try {
            api.register(
                RegisterRequestDto(
                    name = name,
                    email = email,
                    password = password,
                    role = role
                )
            )
        } catch (e: Exception) {
            val message = NetworkErrorHandler.getErrorMessage(e)
            throw Exception(message)
        }
    }

    override suspend fun authenticate(
        email: String,
        password: String
    ): TokenPair {
        return try {
            api.authenticate(
                AuthRequestDto(
                    email = email,
                    password = password
                )
            )
        } catch (e: Exception) {
            val message = NetworkErrorHandler.getErrorMessage(e)
            throw Exception(message)
        }
    }
}