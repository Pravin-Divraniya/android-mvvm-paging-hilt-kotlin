package com.clarion.mvvmdiexample.di.module.fragment

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.adapter.GalleryAdapter
import com.clarion.mvvmdiexample.view.fragment.GalleryFragment
import com.clarion.mvvmdiexample.viewmodel.fragment.GalleryViewModel
import com.clarion.mvvmdiexample.viewmodel.fragment.MainFrgViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 04/10/2018.
 */
@Module
class MainFrgModule {
    @Provides
    fun provideMainFrgViewModel(dataManager: DataManager)
            = MainFrgViewModel(dataManager)

}