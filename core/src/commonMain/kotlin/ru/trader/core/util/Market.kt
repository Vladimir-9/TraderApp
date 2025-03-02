package ru.trader.core.util

enum class Market(val type: String) {
    STOCK("Stock"),
    FORTS("Forts"),
    SPBEX("Spbex"),
    MMA("Mma"),
    ETS("Ets"),
    BOUNDS("Bonds"),
    OPTIONS("Options"),
    Empty("Empty");

    companion object {
        fun getMarket(market: String?) = entries.toTypedArray().find { it.type == market } ?: Empty
    }
}