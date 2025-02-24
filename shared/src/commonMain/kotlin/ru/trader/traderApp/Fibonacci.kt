package ru.trader.traderApp

import kotlinx.coroutines.runBlocking
import ru.trader.traderApp.api.TraderApi
import ru.trader.traderApp.model.CheckApiKeyDto
import ru.trader.traderApp.httpClient.createHttpClient

fun getFibonacciNumbers(count: Int): CheckApiKeyDto {

    val httpClient = createHttpClient("CAEQycHMBhoY7BbYqeMlNsg8NCb0/Bc5hqkGJTpJR8d2")

    val dd = TraderApi(httpClient)

    return runBlocking {
        dd.checkAccessToken()
    }
}