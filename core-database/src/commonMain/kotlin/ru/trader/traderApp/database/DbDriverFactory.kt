package ru.trader.traderApp.database

import app.cash.sqldelight.db.SqlDriver
import ru.trader.traderApp.PlatformConfiguration

expect class DatabaseDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(): SqlDriver
}