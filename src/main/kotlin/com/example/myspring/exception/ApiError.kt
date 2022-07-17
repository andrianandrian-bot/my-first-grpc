package com.example.myspring.exception

data class ApiError(
    val errorCode: Int,
    val description: String
)