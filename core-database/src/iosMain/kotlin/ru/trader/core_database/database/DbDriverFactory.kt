package ru.trader.core_database.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import ru.trader.core_database.PlatformConfiguration

actual class DatabaseDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(TraderDatabase.Schema, "trader.db")
    }
}