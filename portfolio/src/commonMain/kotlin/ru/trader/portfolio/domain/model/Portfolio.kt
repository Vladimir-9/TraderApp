package ru.trader.portfolio.domain.model

import ru.trader.core.model.ErrorResponse
import ru.trader.core.util.Market

data class Portfolio(
    val error: ErrorResponse,
    val data: PortfolioData
)

data class PortfolioData(
    val clientId: String,
    val content: Content,
    val equity: String,
    val balance: String,
    val positions: List<Positions>,
    val currencies: List<Currencies>,
    val money: List<Money>
)

data class Content(
    val includeCurrencies: Boolean,
    val includeMoney: Boolean,
    val includePositions: Boolean,
    val includeMaxBuySell: Boolean
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