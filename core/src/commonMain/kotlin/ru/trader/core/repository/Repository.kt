package ru.trader.core.repository

import ru.trader.core.model.CheckApiKey
import ru.trader.core.model.Portfolio

interface Repository {

    suspend fun checkAuthToken(): CheckApiKey

    suspend fun getPortfolio(
        clientId: String,
        includeCurrencies: Boolean = true,
        includeMoney: Boolean = true,
        includePositions: Boolean = true,
        includeMaxBuySell: Boolean = true,
    ): Portfolio
}