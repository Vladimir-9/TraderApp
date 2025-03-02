package ru.trader.core.model

data class TraderError(
    val code: String,
    val message: String,
    val data: String
)