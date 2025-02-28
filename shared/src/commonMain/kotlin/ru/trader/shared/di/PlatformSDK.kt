package ru.trader.shared.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.trader.shared.MockRepository
import ru.trader.core_database.PlatformConfiguration
import ru.trader.core_database.database.databaseModule

object PlatformSDK {

    private val mockRepositoryModule = module {
        single<MockRepository> {
            MockRepository(
                database = get()
            )
        }
    }

    fun init(configuration: PlatformConfiguration) = startKoin {
        modules(
            mockRepositoryModule,
            databaseModule(configuration)
        )
    }
}

class KoinHelperForIos : KoinComponent {

    private val mockRepository: MockRepository by inject<MockRepository>()

      fun getLaunches():String {
        return mockRepository.get()
    }
}