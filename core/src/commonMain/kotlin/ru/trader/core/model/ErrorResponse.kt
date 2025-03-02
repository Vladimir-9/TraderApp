package ru.trader.core.model

data class ErrorResponse(
    val code: String,
    val message: String,
    val data: String
)