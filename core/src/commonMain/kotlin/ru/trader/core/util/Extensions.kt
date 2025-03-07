package ru.trader.core.util

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import org.koin.core.Koin
import org.koin.core.parameter.ParametersHolder
import org.koin.mp.KoinPlatformTools
import ru.trader.core.SharedViewModel

public inline fun <reified T : SharedViewModel> ComponentContext.getOrCreateViewModel(
    noinline parameters: (() -> ParametersHolder)? = null
): T {
    val koin: Koin = KoinPlatformTools.defaultContext().get()

    return instanceKeeper.getOrCreate(key = T::class, factory = {
        koin.get(parameters = parameters)
    })
}