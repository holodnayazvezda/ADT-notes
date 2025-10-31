package com.example.adt_notes.domain.repository

import com.example.adt_notes.data.network.dto.TokenPair

interface AuthRepository {
    suspend fun register(
        name: String,
        email: String,
        password: String,
        role: String = "USER"
    ) : TokenPair

    suspend fun authenticate(
        email: String,
        password: String
    ) : TokenPair
}