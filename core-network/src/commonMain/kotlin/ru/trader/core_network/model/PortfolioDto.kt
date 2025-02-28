package ru.trader.core_network.model

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioDto(
    val data: DataPortfolioDto?
) : CommonResponseDto()

@Serializable
data class DataPortfolioDto(
    val clientId: String?,
    val content: ContentDto?,
    val equity: String?,
    val balance: String?,
    val positions: List<PositionsDto>,
    val currencies: List<CurrenciesDto>,
    val money: List<MoneyDto>
)

@Serializable
data class ContentDto(
    val includeCurrencies: Boolean?,
    val includeMoney: Boolean?,
    val includePositions: Boolean?,
    val includeMaxBuySell: Boolean?
)

@Serializable
data class PositionsDto(
    val securityCode: String,
    val market: String,
    val balance: Long,
    val currentPrice: Double,
    val equity: Double,
    val averagePrice: Double,
    val currency: String,
    val accumulatedProfit: Double,
    val todayProfit: Double,
    val unrealizedProfit: Double,
    val profit: Double,
    val maxBuy: Long,
    val maxSell: Long,
    val priceCurrency: String,
    val averagePriceCurrency: String,
    val averageRate: Double
)

@Serializable
data class CurrenciesDto(
    val name: String,
    val balance: Double,
    val crossRate: Double,
    val equity: Double,
    val unrealizedProfit: Double
)

@Serializable
data class MoneyDto(
    val market: String,
    val currency: String,
    val balance: Double
)
