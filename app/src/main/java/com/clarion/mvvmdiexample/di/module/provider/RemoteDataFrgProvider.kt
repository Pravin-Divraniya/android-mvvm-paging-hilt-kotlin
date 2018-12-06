package com.clarion.mvvmdiexample.di.module.provider

import com.clarion.mvvmdiexample.di.module.fragment.RemoteDataFrgModule
import com.clarion.mvvmdiexample.view.fragment.RemoteDataFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 11/21/2017.
 */
@Module
abstract class RemoteDataFrgProvider {
    @ContributesAndroidInjector(modules = [(RemoteDataFrgModule::class)])
    abstract fun provideRemoteDataFragmentFactory():RemoteDataFragment
}