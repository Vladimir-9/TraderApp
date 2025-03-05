package ru.trader.core.model

import ru.trader.core.EMPTY_STRING

public data class ErrorResponse(
    val code: String = EMPTY_STRING,
    val message: String = EMPTY_STRING,
    val data: String =EMPTY_STRING,
)