package com.salihakca2.zmovieapp.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class SessionManager @Inject constructor(private val preferences: SharedPreferences) {

    fun getIsFirstRun() = preferences.getBoolean(Constants.FIRST_RUN_KEY,true)

    fun setIsFirstRun(value: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(Constants.FIRST_RUN_KEY,false)
        editor.apply()
    }
}