package com.pravin.mvvmdiexample.di.module.fragment

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.adapter.GalleryAdapter
import com.pravin.mvvmdiexample.view.fragment.GalleryFragment
import com.pravin.mvvmdiexample.viewmodel.fragment.GalleryViewModel
import com.pravin.mvvmdiexample.viewmodel.fragment.MainFrgViewModel
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