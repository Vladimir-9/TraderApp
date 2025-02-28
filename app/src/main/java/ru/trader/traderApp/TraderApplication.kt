package ru.trader.traderApp

import android.app.Application
import ru.trader.core_database.PlatformConfiguration
import ru.trader.shared.di.PlatformSDK

class TraderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        PlatformSDK.init(PlatformConfiguration(this@TraderApplication))
    }
}