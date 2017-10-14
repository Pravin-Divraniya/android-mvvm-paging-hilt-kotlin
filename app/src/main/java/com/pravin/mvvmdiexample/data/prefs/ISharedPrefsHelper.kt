package com.pravin.mvvmdiexample.data.prefs

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
interface ISharedPrefsHelper {
    fun put(key:String,value:String)
    fun get(key:String,defaultValue:String?):String?
}