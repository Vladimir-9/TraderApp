package ru.trader.traderApp

import TraderApp.shared.BuildConfig
import kotlinx.coroutines.runBlocking
import ru.trader.traderApp.api.TraderApi
import ru.trader.traderApp.httpClient.createHttpClient

fun getFibonacciNumbers(count: Int): String {

    val httpClient = createHttpClient(BuildConfig.API_KEY)

    val dd = TraderApi(httpClient)

    return runBlocking {
        val id = dd.checkAccessToken().data?.id.toString()
        dd.getPortfolio(BuildConfig.CLIENT_ID, true, true, true, true)

        "runBlocking"
    }
}