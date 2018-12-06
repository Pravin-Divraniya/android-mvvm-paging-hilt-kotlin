package com.clarion.mvvmdiexample.di.component

import com.clarion.mvvmdiexample.app.MyApplication
import com.clarion.mvvmdiexample.di.builder.ActivityBuilder
import com.clarion.mvvmdiexample.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, AndroidSupportInjectionModule::class, ActivityBuilder::class])
interface AppComponent:AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApplication>()
}