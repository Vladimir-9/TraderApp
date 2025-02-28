package ru.trader.traderApp.database

import org.koin.dsl.module
import ru.trader.traderApp.PlatformConfiguration

fun databaseModule(configuration: PlatformConfiguration) = module {
    single {
        DatabaseDriverFactory(configuration)
    }
    single<Database> {
        Database(get())
    }
}