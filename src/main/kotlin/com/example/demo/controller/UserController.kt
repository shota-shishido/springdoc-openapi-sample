package com.example.demo.controller

import com.example.demo.model.CreateUserRequest
import com.example.demo.model.ErrorResponse
import com.example.demo.model.UserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@Tag(name = "ユーザー管理", description = "ユーザー関連の操作")
class UserController {

    @Operation(
        summary = "ユーザー情報の取得",
        description = "指定されたIDのユーザー情報を返します。ユーザーが存在しない場合は404エラーを返します。"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "成功"),
            ApiResponse(responseCode = "404", description = "ユーザーが見つかりません"),
            ApiResponse(
                responseCode = "500",
                description = "サーバーエラー",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )]
    )
    @GetMapping("/{id}")
    private fun getUser(
        @Parameter(description = "ユーザーID", required = true, example = "12345")
        @PathVariable id: Int
    ): ResponseEntity<UserResponse> {
        val user = UserResponse(id, "ユーザー$id", 30)
        return ResponseEntity.ok(user)
    }

    @Operation(
        summary = "新規ユーザーの作成",
        description = "ユーザー情報を受け取り、新規ユーザーを作成します。"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "ユーザーが作成されました"),
            ApiResponse(responseCode = "400", description = "無効なリクエストデータ"),
            ApiResponse(
                responseCode = "500",
                description = "サーバーエラー",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )]
    )
    @PostMapping
    fun createUser(
        @RequestBody
        user: CreateUserRequest
    ): ResponseEntity<UserResponse> {
        val createdUser = UserResponse(1, user.name, user.age)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }
}