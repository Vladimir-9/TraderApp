package ru.trader.traderApp

import android.app.Application
import ru.trader.traderApp.di.PlatformSDK

class TraderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        PlatformSDK.init(PlatformConfiguration(this@TraderApplication))
    }
}