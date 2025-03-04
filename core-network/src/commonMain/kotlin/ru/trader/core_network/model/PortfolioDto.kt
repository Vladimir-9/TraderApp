package ru.trader.core_network.model

import kotlinx.serialization.Serializable
import ru.trader.core.EMPTY_DOUBLE
import ru.trader.core.EMPTY_LONG
import ru.trader.core.EMPTY_STRING

@Serializable
data class PortfolioDto(
    val data: PortfolioDataDto = PortfolioDataDto(),
) : CommonResponseDto()

@Serializable
data class PortfolioDataDto(
    val clientId: String = EMPTY_STRING,
    val content: ContentDto = ContentDto(),
    val equity: String = EMPTY_STRING,
    val balance: String = EMPTY_STRING,
    val positions: List<PositionsDto> = emptyList(),
    val currencies: List<CurrenciesDto> = emptyList(),
    val money: List<MoneyDto> = emptyList(),
)

@Serializable
data class ContentDto(
    val includeCurrencies: Boolean = false,
    val includeMoney: Boolean = false,
    val includePositions: Boolean = false,
    val includeMaxBuySell: Boolean = false,
)

@Serializable
data class PositionsDto(
    val securityCode: String = EMPTY_STRING,
    val market: String = EMPTY_STRING,
    val balance: Long = EMPTY_LONG,
    val currentPrice: Double = EMPTY_DOUBLE,
    val equity: Double = EMPTY_DOUBLE,
    val averagePrice: Double = EMPTY_DOUBLE,
    val currency: String = EMPTY_STRING,
    val accumulatedProfit: Double = EMPTY_DOUBLE,
    val todayProfit: Double = EMPTY_DOUBLE,
    val unrealizedProfit: Double = EMPTY_DOUBLE,
    val profit: Double = EMPTY_DOUBLE,
    val maxBuy: Long = EMPTY_LONG,
    val maxSell: Long = EMPTY_LONG,
    val priceCurrency: String = EMPTY_STRING,
    val averagePriceCurrency: String = EMPTY_STRING,
    val averageRate: Double = EMPTY_DOUBLE,
)

@Serializable
data class CurrenciesDto(
    val name: String = EMPTY_STRING,
    val balance: Double = EMPTY_DOUBLE,
    val crossRate: Double = EMPTY_DOUBLE,
    val equity: Double = EMPTY_DOUBLE,
    val unrealizedProfit: Double = EMPTY_DOUBLE,
)

@Serializable
data class MoneyDto(
    val market: String = EMPTY_STRING,
    val currency: String = EMPTY_STRING,
    val balance: Double = EMPTY_DOUBLE,
)
