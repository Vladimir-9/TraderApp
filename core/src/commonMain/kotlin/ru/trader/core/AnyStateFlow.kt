package ru.trader.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

public interface Cancellable {
    public fun cancel()
}

public class AnyStateFlow<T : Any>(
    private val source: StateFlow<T>
) : StateFlow<T> by source {
    override val value: T
        get() = source.value

    public fun collect(
        onEach: (T) -> Unit
    ): Cancellable {
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

        this.source.onEach {
            onEach(it)
        }.launchIn(scope)

        return object : Cancellable {
            override fun cancel() {
                scope.cancel()
            }
        }
    }
}

public fun <T : Any> StateFlow<T>.wrapToAny(): AnyStateFlow<T> = AnyStateFlow(this)