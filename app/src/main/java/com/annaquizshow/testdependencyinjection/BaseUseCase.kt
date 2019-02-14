package com.annaquizshow.testdependencyinjection

import com.annaquizshow.testdependencyinjection.network.models.ResponseWraper
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    protected val deferreds = mutableListOf<Deferred<*>>()

    fun clear() {
        deferreds.onEach {
            if (!it.isCancelled) it.cancel()
        }.clear()
    }

    fun <T>call(job: () -> Deferred<T>) : Deferred<T> {
        val res = job.invoke()
        deferreds.add(res)
        return res
    }

    fun io(function : suspend () -> Unit) = launch (Dispatchers.IO) {
        function.invoke()
    }

    fun main(function : suspend () -> Unit) = launch (Dispatchers.Main) {
        function.invoke()
    }

    fun <T>result(job : () -> ResponseWraper<T>) : ResponseWraper<T> = try {
        job.invoke()
    } catch (e : HttpException) {
        ResponseWraper.Error(e.message())
    } catch (t : Throwable) {
        ResponseWraper.Error(t.message ?: "Other error")
    }

}