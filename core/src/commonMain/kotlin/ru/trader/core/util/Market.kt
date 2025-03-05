package ru.trader.core.util

public enum class Market(private val type: String) {
    STOCK("Stock"),
    FORTS("Forts"),
    SPBEX("Spbex"),
    MMA("Mma"),
    ETS("Ets"),
    BOUNDS("Bonds"),
    OPTIONS("Options"),
    Empty("Empty");

    public companion object {
        public fun getMarket(market: String): Market =
            entries.toTypedArray().find { it.type == market } ?: Empty
    }
}