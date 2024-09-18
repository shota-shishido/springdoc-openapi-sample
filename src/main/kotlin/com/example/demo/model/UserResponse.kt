package com.example.demo.model

import io.swagger.v3.oas.annotations.media.Schema

data class UserResponse(
    @Schema(description = "ユーザーID", example = "12345")
    val id: Int,

    @Schema(description = "ユーザー名", example = "John Doe")
    val name: String,

    @Schema(description = "ユーザーの年齢", minimum = "0", maximum = "150")
    val age: Int
)