package ru.trader.traderApp

import TraderApp.shared.BuildConfig
import kotlinx.coroutines.runBlocking
import ru.trader.traderApp.api.TraderApi
import ru.trader.traderApp.database.Database
import ru.trader.traderApp.httpClient.createHttpClient

class MockRepository(private val database: Database) {

    fun get(): String {

        val httpClient = createHttpClient(BuildConfig.API_KEY)

        val dd = TraderApi(httpClient)

        return runBlocking {
            val id = dd.checkAccessToken().data?.id.toString()

            database.createUserId(id)

            dd.getPortfolio(BuildConfig.CLIENT_ID, true, true, true, true)

            database.getIdUser()
        }
    }
}
