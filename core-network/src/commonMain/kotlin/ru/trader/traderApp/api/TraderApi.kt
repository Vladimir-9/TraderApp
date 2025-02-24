package ru.trader.traderApp.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path
import ru.trader.traderApp.model.CheckApiKeyDto

class TraderApi(private val httpClient: HttpClient) {

    private companion object {
        const val DEFAULT_PATH = "public/api/v1/"
    }

    suspend fun checkAccessToken() = httpClient.get {
        url {
            path("${DEFAULT_PATH}access-tokens/check")
        }
    }.body<CheckApiKeyDto>()
}