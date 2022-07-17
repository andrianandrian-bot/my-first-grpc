package com.example.myspring.exception

import org.springframework.http.HttpStatus

class TrainingNotFoundException: BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = 404,
        description = "Country not found. Try again"
    )
)