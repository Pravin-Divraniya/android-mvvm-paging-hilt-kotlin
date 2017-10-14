package com.pravin.mvvmdiexample.di.component

import android.app.Application
import com.pravin.mvvmdiexample.app.MyApplication
import com.pravin.mvvmdiexample.di.builder.ActivityBuilder
import com.pravin.mvvmdiexample.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application):Builder

        fun build():AppComponent
    }

    fun inject(application: MyApplication)
}