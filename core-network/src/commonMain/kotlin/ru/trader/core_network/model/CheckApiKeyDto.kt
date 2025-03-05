package ru.trader.core_network.model

import kotlinx.serialization.Serializable
import ru.trader.core.EMPTY_INT

@Serializable
data class CheckApiKeyDto(
    val data: DataCheckApiKeyDto? = null,
) : CommonResponseDto()

@Serializable
data class DataCheckApiKeyDto(
    val id: Int = EMPTY_INT,
)