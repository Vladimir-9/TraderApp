package ru.trader.core_network.di

import TraderApp.core_network.BuildConfig
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.trader.core_network.api.TraderApi
import ru.trader.core_network.httpClient.createHttpClient

val networkModule = module {
    single { createHttpClient(BuildConfig.API_KEY) }
    singleOf(::TraderApi)
}