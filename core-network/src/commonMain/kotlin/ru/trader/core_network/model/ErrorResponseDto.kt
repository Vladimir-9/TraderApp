package ru.trader.core_network.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    val code: String?,
    val message: String?,
    val data: String?,
)