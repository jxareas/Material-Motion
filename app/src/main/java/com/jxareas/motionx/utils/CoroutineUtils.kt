package com.jxareas.motionx.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

sealed interface DispatcherProvider {
    val default : CoroutineDispatcher
    val io : CoroutineDispatcher
    val main : CoroutineDispatcher
    val unconfined : CoroutineDispatcher
}

object DefaultDispatchers : DispatcherProvider {
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
    override val main: CoroutineDispatcher
        get() = Dispatchers.Default
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined

}