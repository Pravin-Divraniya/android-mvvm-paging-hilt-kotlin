package com.pravin.mvvmdiexample.di.component

import com.pravin.mvvmdiexample.app.MyApplication
import com.pravin.mvvmdiexample.di.builder.ActivityBuilder
import com.pravin.mvvmdiexample.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, ActivityBuilder::class])
interface AppComponent:AndroidInjector<MyApplication> {

    @Component.Factory
    interface Builder: AndroidInjector.Factory<MyApplication>
}