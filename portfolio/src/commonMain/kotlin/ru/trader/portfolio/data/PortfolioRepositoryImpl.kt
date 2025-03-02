package ru.trader.portfolio.data

import ru.trader.portfolio.domain.PortfolioRepository
import ru.trader.core.util.SafeApiCall
import ru.trader.core_network.api.TraderApi

class PortfolioRepositoryImpl(private val api: TraderApi) : PortfolioRepository, SafeApiCall() {

    override suspend fun getPortfolio(
        clientId: String,
        includeCurrencies: Boolean,
        includeMoney: Boolean,
        includePositions: Boolean,
        includeMaxBuySell: Boolean
    ) = safeApiCall {

        api.getPortfolio(
            clientId,
            includeCurrencies,
            includeMoney,
            includePositions,
            includeMaxBuySell
        ).toDomain()
    }
}