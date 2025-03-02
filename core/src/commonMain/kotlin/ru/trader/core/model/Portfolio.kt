package ru.trader.core.model

data class Portfolio(
    val error: TraderError,
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

data class Currencies(
    val name: String,
    val balance: Double,
    val crossRate: Double,
    val equity: Double,
    val unrealizedProfit: Double
)

data class Money(
    val market: String,
    val currency: String,
    val balance: Double
)