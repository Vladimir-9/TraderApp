package ru.trader.shared

import TraderApp.shared.BuildConfig
import kotlinx.coroutines.runBlocking
import ru.trader.core_network.api.TraderApi
import ru.trader.core_database.database.Database
import ru.trader.core_network.httpClient.createHttpClient

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
