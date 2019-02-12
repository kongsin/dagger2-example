package com.annaquizshow.testdependencyinjection

import android.content.Context
import android.util.Log

class UserProfileManager(val context: Context) {

    var name : String = ""
    var age : Int = 0

    fun saveUser(name: String = "", age: Int = 0) {
        this.name = name
        this.age = age
    }

    fun getUser() {
        Log.i("USER_MANAGER", "SAVE : name -> $name, age -> $age")
    }

    fun deleteUser() {
        name = ""
        age = 0
    }

}