package ru.trader.core.repository

import ru.trader.core.model.CheckApiKey

interface AuthRepository {

    suspend fun checkAuthToken(): CheckApiKey
}