package com.annaquizshow.testdependencyinjection

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    protected val deferreds = mutableListOf<Deferred<*>>()

    fun clear() {
        deferreds.onEach {
            if (!it.isCancelled) it.cancel()
        }
        deferreds.clear()
    }

    fun io(function : suspend () -> Unit) = launch(Dispatchers.IO) {
        function.invoke()
    }

    fun main(function : suspend () -> Unit) = launch(Dispatchers.Main) {
        function.invoke()
    }
}