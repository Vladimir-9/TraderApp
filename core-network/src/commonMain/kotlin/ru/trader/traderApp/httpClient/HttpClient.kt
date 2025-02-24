package ru.trader.traderApp.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import ru.trader.traderApp.httpEngineFactory

private const val URL_PROD = "https://trade-api.finam.ru/"

private const val TIMEOUT: Long = 30_000

fun createHttpClient(apiKey: String) = HttpClient(httpEngineFactory()) {

    expectSuccess = true

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                println("HttpClient: $message")
            }
        }
        level = LogLevel.ALL
    }

    install(ContentNegotiation) {
        json(
            getJson()
        )
    }

    install(HttpTimeout) {
        connectTimeoutMillis = TIMEOUT
        socketTimeoutMillis = TIMEOUT
        requestTimeoutMillis = TIMEOUT
    }

    defaultRequest {

        url(URL_PROD)

        headers {
            append("X-Api-Key", apiKey)
        }
    }
}
