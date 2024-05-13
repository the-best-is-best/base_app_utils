package com.tbib.base_app_utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class AndroidDispatcher : Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}

internal actual fun providerDispatcher(): Dispatcher = AndroidDispatcher()