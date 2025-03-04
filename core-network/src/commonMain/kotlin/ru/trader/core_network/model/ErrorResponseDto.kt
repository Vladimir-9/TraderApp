package ru.trader.core_network.model

import kotlinx.serialization.Serializable
import ru.trader.core.EMPTY_STRING

@Serializable
data class ErrorResponseDto(
    val code: String = EMPTY_STRING,
    val message: String = EMPTY_STRING,
    val data: String = EMPTY_STRING,
)