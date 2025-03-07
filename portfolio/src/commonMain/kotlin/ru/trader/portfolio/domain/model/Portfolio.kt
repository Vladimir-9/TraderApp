package ru.trader.portfolio.domain.model

import kotlinx.serialization.Serializable
import ru.trader.core.EMPTY_STRING
import ru.trader.core.model.ErrorResponse
import ru.trader.core.util.Market

data class Portfolio(
    val error: ErrorResponse = ErrorResponse(),
    val data: PortfolioData = PortfolioData(),
)

data class PortfolioData(
    val clientId: String = EMPTY_STRING,
    val content: Content = Content(),
    val equity: String = EMPTY_STRING,
    val balance: String = EMPTY_STRING,
    val positions: List<Position> = emptyList(),
    val currencies: List<Currency> = emptyList(),
    val money: List<Money> = emptyList()
)

data class Content(
    val includeCurrencies: Boolean = false,
    val includeMoney: Boolean = false,
    val includePositions: Boolean = false,
    val includeMaxBuySell: Boolean = false,
)

@Serializable
data class Position(
    val securityCode: String,
    val market: Market,
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

data class Currency(
    val name: String,
    val balance: Double,
    val crossRate: Double,
    val equity: Double,
    val unrealizedProfit: Double
)

data class Money(
    val market: Market,
    val currency: String,
    val balance: Double
)