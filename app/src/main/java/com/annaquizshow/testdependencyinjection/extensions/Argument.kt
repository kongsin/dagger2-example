@file:Suppress("UNCHECKED_CAST")

package com.annaquizshow.testdependencyinjection.extensions

import android.app.Activity

fun <T : Any> Activity.argument(key: String) = lazy { this.intent.extras?.get(key) as T }