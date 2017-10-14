package com.pravin.mvvmdiexample.app

import android.app.Activity
import android.app.Application
import com.pravin.mvvmdiexample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
class MyApplication : Application(),HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector:DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}