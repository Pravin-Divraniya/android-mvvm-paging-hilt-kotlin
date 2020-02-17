package com.pravin.mvvmdiexample.app

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.pravin.mvvmdiexample.utils.HttpClientUtils.getUnsafeOkHttpClient
import com.pravin.mvvmdiexample.BuildConfig
import com.pravin.mvvmdiexample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
class MyApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(this,getUnsafeOkHttpClient())

        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
    }
    
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)
}