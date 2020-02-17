package com.pravin.mvvmdiexample.di.module.provider

import com.pravin.mvvmdiexample.di.module.fragment.GalleryFrgModule
import com.pravin.mvvmdiexample.di.module.fragment.MainFrgModule
import com.pravin.mvvmdiexample.view.fragment.GalleryFragment
import com.pravin.mvvmdiexample.view.fragment.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 04/10/2018.
 */
@Module
abstract class MainFrgProvider {

    @ContributesAndroidInjector(modules = [(MainFrgModule::class)])
    abstract fun provideMainFragmentFactory():MainFragment
}