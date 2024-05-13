package com.tbib.base_app_utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


internal class IosDispatcher : Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default

}

internal actual fun providerDispatcher(): Dispatcher = IosDispatcher()