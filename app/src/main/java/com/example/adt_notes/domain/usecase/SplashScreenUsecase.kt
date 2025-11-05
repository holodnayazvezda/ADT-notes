package com.example.adt_notes.domain.usecase

import com.example.adt_notes.data.network.dto.UserResponseDto
import com.example.adt_notes.domain.repository.AuthRepository

class SplashScreenUsecase(
    private val repository: AuthRepository
) {
    suspend fun invoke(accessToken: String): UserResponseDto {
        val authToken = "Bearer $accessToken"
        return repository.getAuthorizedUser(authToken)
    }
}