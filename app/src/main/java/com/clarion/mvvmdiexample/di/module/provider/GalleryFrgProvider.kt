package com.clarion.mvvmdiexample.di.module.provider

import com.clarion.mvvmdiexample.di.module.fragment.GalleryFrgModule
import com.clarion.mvvmdiexample.view.fragment.GalleryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 04/10/2018.
 */
@Module
abstract class GalleryFrgProvider {

    @ContributesAndroidInjector(modules = [(GalleryFrgModule::class)])
    abstract fun provideGalleryFragmentFactory():GalleryFragment
}