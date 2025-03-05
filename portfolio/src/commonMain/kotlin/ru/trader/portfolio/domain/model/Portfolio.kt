package ru.trader.portfolio.domain.model

import ru.trader.core.EMPTY_STRING
import ru.trader.core.model.ErrorResponse
import ru.trader.core.util.Market

data class Portfolio(
    val error: ErrorResponse,
    val data: PortfolioData
)

data class PortfolioData(
    val clientId: String = EMPTY_STRING,
    val content: Content = Content(),
    val equity: String = EMPTY_STRING,
    val balance: String = EMPTY_STRING,
    val positions: List<Positions> = emptyList(),
    val currencies: List<Currencies> = emptyList(),
    val money: List<Money> = emptyList()
)

data class Content(
    val includeCurrencies: Boolean = false,
    val includeMoney: Boolean = false,
    val includePositions: Boolean = false,
    val includeMaxBuySell: Boolean = false,
)

data class Positions(
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

data class Currencies(
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