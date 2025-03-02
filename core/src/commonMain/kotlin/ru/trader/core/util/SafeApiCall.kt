package ru.trader.core.util

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class SafeApiCall {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {

        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (ex: Exception) {
                handleError(ex)
            }
        }
    }

    private fun handleError(ex: Exception): Resource.Failure {
        return when (ex) {

            is CancellationException -> {
                Resource.Failure(ex)
                throw ex
            }

            else -> Resource.Failure(ex)
        }
    }
}