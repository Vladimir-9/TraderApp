package ru.trader.core_network.httpClient

import kotlinx.serialization.json.Json

fun getJson(): Json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    prettyPrint = true
}