package ru.trader.core_database.database

import org.koin.dsl.module
import ru.trader.core_database.PlatformConfiguration

fun databaseModule(configuration: PlatformConfiguration) = module {
    single {
        DatabaseDriverFactory(configuration)
    }
    single<Database> {
        Database(get())
    }
}