package ru.trader.core.util

public sealed class Resource<out T> {

    public data class Success<out T>(val value: T) : Resource<T>()

    public data class Failure(
        val throwable: Throwable? = null,
        val errorCode: Int? = null
    ) : Resource<Nothing>()
}