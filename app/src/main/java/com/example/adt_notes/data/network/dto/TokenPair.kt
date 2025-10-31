package com.example.adt_notes.data.network.dto

import com.google.gson.annotations.SerializedName

data class TokenPair(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String?
)
