package com.annaquizshow.testdependencyinjection

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class BaseUseCase {

    val deferreds = mutableListOf<Deferred<*>>()

    fun clear() {
        deferreds.onEach {
            if (!it.isCancelled) it.cancel()
        }
        deferreds.clear()
    }

    fun main(function : () -> Unit) = GlobalScope.launch(Dispatchers.Main) {
        function.invoke()
    }
}