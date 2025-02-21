package ru.trader.traderApp.model

import kotlinx.serialization.Serializable

@Serializable
abstract class CommonResponseDto {
    val error: ErrorResponseDto? = null
}
