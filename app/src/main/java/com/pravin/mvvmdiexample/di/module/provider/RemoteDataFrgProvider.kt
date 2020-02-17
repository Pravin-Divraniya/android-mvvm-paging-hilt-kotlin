package com.pravin.mvvmdiexample.di.module.provider

import com.pravin.mvvmdiexample.di.module.fragment.RemoteDataFrgModule
import com.pravin.mvvmdiexample.view.fragment.RemoteDataFragment
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