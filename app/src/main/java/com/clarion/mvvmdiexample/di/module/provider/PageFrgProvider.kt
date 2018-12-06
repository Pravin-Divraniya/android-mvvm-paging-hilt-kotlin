package com.clarion.mvvmdiexample.di.module.provider

import com.clarion.mvvmdiexample.di.module.fragment.PageFrgModule
import com.clarion.mvvmdiexample.view.fragment.PageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 12/19/2017.
 */
@Module
abstract class PageFrgProvider {
    @ContributesAndroidInjector(modules = arrayOf(PageFrgModule::class))
    abstract fun providePageFragment():PageFragment
}