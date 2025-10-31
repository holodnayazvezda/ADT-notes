package com.example.adt_notes.data.network.api

import com.example.adt_notes.data.network.dto.AuthRequestDto
import com.example.adt_notes.data.network.dto.RegisterRequestDto
import com.example.adt_notes.data.network.dto.TokenPair
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/register")
    suspend fun register(
        @Body request: RegisterRequestDto
    ): TokenPair

    @POST("/auth/authenticate")
    suspend fun authenticate(
        @Body request: AuthRequestDto
    ): TokenPair
}