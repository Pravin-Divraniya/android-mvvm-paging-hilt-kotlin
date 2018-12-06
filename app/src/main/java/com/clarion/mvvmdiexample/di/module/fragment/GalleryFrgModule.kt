package com.clarion.mvvmdiexample.di.module.fragment

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.adapter.GalleryAdapter
import com.clarion.mvvmdiexample.view.fragment.GalleryFragment
import com.clarion.mvvmdiexample.viewmodel.fragment.GalleryViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 04/10/2018.
 */
@Module
class GalleryFrgModule {
    @Provides
    fun provideGalleryViewModel(dataManager: DataManager)
            = GalleryViewModel(dataManager)

    @Provides
    fun provideGalleryAdapter(fragment: GalleryFragment) = GalleryAdapter(GalleryAdapter.DIFF_CALLBACK,fragment)
}