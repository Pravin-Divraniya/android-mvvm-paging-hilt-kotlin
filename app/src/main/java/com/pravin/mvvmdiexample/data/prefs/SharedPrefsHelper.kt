package com.pravin.mvvmdiexample.data.prefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Singleton
class SharedPrefsHelper:ISharedPrefsHelper {
    companion object {
        var PREF_KEY_ACCESS_TOKEN:String = "access-token"
    }
    val mSharedPreferences: SharedPreferences

    @Inject
    constructor(mSharedPreferences: SharedPreferences){
        this.mSharedPreferences = mSharedPreferences
    }
    override fun put(key:String, value:String){
        mSharedPreferences.edit().putString(key,value).apply()
    }
    override fun get(key:String, defaultValue:String?):String? = mSharedPreferences.getString(key,defaultValue)
}