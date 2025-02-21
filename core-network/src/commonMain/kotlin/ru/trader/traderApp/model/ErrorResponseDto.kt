package ru.trader.traderApp.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    val code: String? = null,
    val message: String? = null,
    val data: String? = null
)