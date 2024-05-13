package com.tbib.base_app_utils

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun providerDispatcher(): Dispatcher