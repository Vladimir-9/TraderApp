package ru.trader.traderApp.model

import kotlinx.serialization.Serializable

@Serializable
data class CheckApiKeyDto(
    val data: DataCheckApiKeyDto? = null
) : CommonResponseDto()

@Serializable
data class DataCheckApiKeyDto(
    val id: Int? = null
)