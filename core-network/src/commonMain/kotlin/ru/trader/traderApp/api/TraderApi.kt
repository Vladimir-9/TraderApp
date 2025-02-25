package ru.trader.traderApp.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import ru.trader.traderApp.model.CheckApiKeyDto
import ru.trader.traderApp.model.PortfolioDto

class TraderApi(private val httpClient: HttpClient) {

    private companion object {
        const val DEFAULT_PATH = "public/api/v1/"
    }

    suspend fun checkAccessToken() = httpClient.get {
        url {
            path("${DEFAULT_PATH}access-tokens/check")
        }
    }.body<CheckApiKeyDto>()

    suspend fun getPortfolio(
        clientId: String,
        includeCurrencies: Boolean,
        includeMoney: Boolean,
        includePositions: Boolean,
        includeMaxBuySell: Boolean,
    ) = httpClient.get {
        url {
            path("${DEFAULT_PATH}portfolio")

            parameter("ClientId", clientId)

            parameter("Content.IncludeCurrencies", includeCurrencies)  // Валютные позиции
            parameter("Content.IncludeMoney", includeMoney)            // Денежные позиции
            parameter("Content.IncludePositions", includePositions)    // акции в портфеле.
            parameter("Content.IncludeMaxBuySell", includeMaxBuySell)  // Лимиты покупки и продажи.
        }
    }.body<PortfolioDto>()
}