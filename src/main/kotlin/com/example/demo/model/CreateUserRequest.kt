package com.example.demo.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "CreateUserRequest", description = "作成する利用者の情報")
data class CreateUserRequest(
    @field:Schema(description = "ユーザー名", example = "John Doe", required = true)
    val name: String,

    @field:Schema(description = "ユーザーの年齢", example = "30", minimum = "0", maximum = "150")
    val age: Int,

    @field:Schema(description = "メールアドレス", example = "john@example.com")
    val email: String
)