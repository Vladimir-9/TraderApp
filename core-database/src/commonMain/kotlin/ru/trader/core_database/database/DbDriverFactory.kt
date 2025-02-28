package ru.trader.core_database.database

import app.cash.sqldelight.db.SqlDriver
import ru.trader.core_database.PlatformConfiguration

expect class DatabaseDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(): SqlDriver
}