package com.example.motivation.infra

import android.content.Context

class SecurityPreferences (context: Context){
    private val mSharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)

    fun storeString(key:String, value:String) {
        mSharedPreferences.edit().putString(key,value).apply()
    }

    fun getString (key:String): String {
        return mSharedPreferences.getString(key, "").orEmpty()

    }
    private companion object {
        private const val SHARED_PREFERENCES_KEY = "motivation"
    }
}