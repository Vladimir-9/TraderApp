package ru.trader.core_network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

expect fun httpEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig>