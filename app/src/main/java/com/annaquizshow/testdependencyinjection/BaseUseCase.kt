package com.annaquizshow.testdependencyinjection

import kotlinx.coroutines.*
import retrofit2.Response
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

    fun io(function : suspend () -> Unit) = async(Dispatchers.IO) {
        function.invoke()
    }

    fun main(function : suspend () -> Unit) = launch(Dispatchers.Main) {
        function.invoke()
    }
}