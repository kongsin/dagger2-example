package com.annaquizshow.testdependencyinjection.network.models

sealed class ResponseWraper<T> {
    class Success<T>(val info: T) : ResponseWraper<T>()
    class Error<T>(val message: String) : ResponseWraper<T>()
}