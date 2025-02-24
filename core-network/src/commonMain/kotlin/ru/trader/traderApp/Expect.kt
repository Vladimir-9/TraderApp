package ru.trader.traderApp

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

expect fun httpEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig>