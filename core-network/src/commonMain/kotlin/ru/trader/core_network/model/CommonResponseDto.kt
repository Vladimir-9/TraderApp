package ru.trader.core_network.model

import kotlinx.serialization.Serializable
@Serializable
abstract class CommonResponseDto {
    val error: ErrorResponseDto = ErrorResponseDto()
}
