package com.pravin.mvvmdiexample.di.module.provider

import com.pravin.mvvmdiexample.di.module.fragment.MyDialogFrgModule
import com.pravin.mvvmdiexample.view.fragment.MyDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 11/29/2017.
 */
@Module
abstract class MyDialogFrgProvider {
    @ContributesAndroidInjector(modules = arrayOf(MyDialogFrgModule::class))
    abstract fun provideMyDialogFragmentFactory() : MyDialogFragment
}