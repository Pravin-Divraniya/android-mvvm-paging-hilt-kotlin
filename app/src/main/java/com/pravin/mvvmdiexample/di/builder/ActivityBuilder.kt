package com.pravin.mvvmdiexample.di.builder

import com.pravin.mvvmdiexample.di.module.MainActivityModule
import com.pravin.mvvmdiexample.di.module.MainListActivityModule
import com.pravin.mvvmdiexample.view.activity.MainActivity
import com.pravin.mvvmdiexample.view.activity.MainListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector(modules = arrayOf(MainListActivityModule::class))
    abstract fun bindMainListActivity():MainListActivity
}