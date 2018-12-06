package com.clarion.mvvmdiexample.app

import android.content.Context
import android.os.Build
import android.support.multidex.MultiDex
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.clarion.mvvmdiexample.BuildConfig
import com.clarion.mvvmdiexample.di.component.AppComponent
import com.clarion.mvvmdiexample.di.component.DaggerAppComponent
import com.clarion.mvvmdiexample.utils.HttpClientUtils.getUnsafeOkHttpClient
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

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            MultiDex.install(this)
    }
}