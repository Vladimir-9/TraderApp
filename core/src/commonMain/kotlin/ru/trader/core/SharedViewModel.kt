package ru.trader.core

import co.touchlab.kermit.Logger
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

public abstract class SharedViewModel : InstanceKeeper.Instance {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e("SharedViewModel", throwable)
    }

    protected val coroutineScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate + coroutineExceptionHandler)

    override fun onDestroy() {
        coroutineScope.cancel()
    }
}