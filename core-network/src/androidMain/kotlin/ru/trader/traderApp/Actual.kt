package ru.trader.traderApp

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android

actual fun httpEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> = Android