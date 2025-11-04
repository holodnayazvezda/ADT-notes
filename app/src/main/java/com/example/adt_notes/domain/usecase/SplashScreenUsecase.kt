package com.example.adt_notes.domain.usecase

import com.example.adt_notes.data.network.dto.UserResponseDTO
import com.example.adt_notes.domain.repository.AuthRepository

class SplashScreenUsecase(
    private val repository: AuthRepository
) {
    suspend fun invoke(accessToken: String): UserResponseDTO {
        val authToken = "Bearer $accessToken"
        return repository.getAuthorizedUser(authToken)
    }
}