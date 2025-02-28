package ru.trader.core_network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android

actual fun httpEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> = Android