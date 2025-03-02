package ru.trader.core.util

sealed class Resource<out T> {

    data class Success<out T>(val value: T) : Resource<T>()

    data class Failure(
        val throwable: Throwable? = null,
        val errorCode: Int? = null
    ) : Resource<Nothing>()
}