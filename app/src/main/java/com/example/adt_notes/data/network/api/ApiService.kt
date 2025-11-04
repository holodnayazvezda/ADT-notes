package com.example.adt_notes.data.network.api

import com.example.adt_notes.data.network.dto.AuthRequestDto
import com.example.adt_notes.data.network.dto.RegisterRequestDto
import com.example.adt_notes.data.network.dto.TokenPair
import com.example.adt_notes.data.network.dto.UserResponseDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/auth/register")
    suspend fun register(
        @Body request: RegisterRequestDto
    ): TokenPair

    @POST("/api/v1/auth/authenticate")
    suspend fun authenticate(
        @Body request: AuthRequestDto
    ): TokenPair

    @GET("/user/me")
    suspend fun getAuthorizedUser(
        @Header("Authorization") accessToken: String
    ): UserResponseDTO
}