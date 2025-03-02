package ru.trader.portfolio.domain

import ru.trader.core.util.Resource
import ru.trader.portfolio.domain.model.Portfolio

interface PortfolioRepository {

    suspend fun getPortfolio(
        clientId: String,
        includeCurrencies: Boolean = true,
        includeMoney: Boolean = true,
        includePositions: Boolean = true,
        includeMaxBuySell: Boolean = true,
    ): Resource<Portfolio>
}