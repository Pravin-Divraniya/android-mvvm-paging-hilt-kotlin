package com.clarion.mvvmdiexample.di.module.provider

import com.clarion.mvvmdiexample.di.module.fragment.GalleryFrgModule
import com.clarion.mvvmdiexample.di.module.fragment.MainFrgModule
import com.clarion.mvvmdiexample.view.fragment.GalleryFragment
import com.clarion.mvvmdiexample.view.fragment.MainFragment
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