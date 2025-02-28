package ru.trader.traderApp.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import ru.trader.traderApp.PlatformConfiguration
import ru.trader.traderApp.cache.TraderDatabase

actual class DatabaseDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(TraderDatabase.Schema, "trader.db")
    }
}