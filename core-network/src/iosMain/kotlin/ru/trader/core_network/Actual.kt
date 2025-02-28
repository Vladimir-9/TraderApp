package ru.trader.core_network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.engine.darwin.DarwinHttpRequestException
import platform.Foundation.NSError
import kotlin.concurrent.AtomicReference

actual fun httpEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> {

    ThrowableToNSErrorMapper.setup { (it as? DarwinHttpRequestException)?.origin }

    return Darwin
}

object ThrowableToNSErrorMapper : (Throwable) -> NSError? {
    private val mapperRef: AtomicReference<((Throwable) -> NSError?)?> = AtomicReference(null)

    override fun invoke(throwable: Throwable): NSError? {
        @Suppress("MaxLineLength")
        return requireNotNull(mapperRef.value) {
            "please setup ThrowableToNSErrorMapper by call ThrowableToNSErrorMapper.setup() in iosMain"
        }.invoke(throwable)
    }

    fun setup(block: (Throwable) -> NSError?) {
        mapperRef.value = block
    }
}