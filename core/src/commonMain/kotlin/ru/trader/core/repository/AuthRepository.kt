package ru.trader.core.repository

import ru.trader.core.model.CheckApiKey

public interface AuthRepository {

    public suspend fun checkAuthToken(): CheckApiKey
}