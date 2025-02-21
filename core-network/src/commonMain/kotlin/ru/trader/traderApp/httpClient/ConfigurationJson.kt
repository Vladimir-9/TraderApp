package ru.trader.traderApp.httpClient

import kotlinx.serialization.json.Json

fun getJson(): Json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    prettyPrint = true
}