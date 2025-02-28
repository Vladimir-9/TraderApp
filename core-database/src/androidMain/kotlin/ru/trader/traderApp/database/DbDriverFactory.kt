package ru.trader.traderApp.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.trader.traderApp.PlatformConfiguration
import ru.trader.traderApp.cache.TraderDatabase

actual class DatabaseDriverFactory actual constructor(private val platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(TraderDatabase.Schema, platformConfiguration.androidContext, "trader.db")
    }
}