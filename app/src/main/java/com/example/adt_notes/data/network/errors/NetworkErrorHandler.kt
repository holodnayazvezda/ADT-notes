package com.example.adt_notes.data.network.errors

import com.example.adt_notes.data.network.dto.ErrorResponseDTO
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

object NetworkErrorHandler {
    fun getErrorMessage(e: Throwable): String {
        return when (e) {
            is IOException -> "No internet connection"
            is HttpException -> {
                val errorBody = e.response()?.errorBody()?.string()
                val parsed = try {
                    Gson().fromJson(errorBody, ErrorResponseDTO::class.java)
                } catch (_: Exception) {
                    null
                }
                parsed?.message ?: "Server error (${e.code()})"
            }
            else -> e.message ?: "Unexpected error occurred"
        }
    }
}