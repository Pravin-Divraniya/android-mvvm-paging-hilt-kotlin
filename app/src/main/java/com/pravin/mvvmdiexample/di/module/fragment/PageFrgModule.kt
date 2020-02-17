package com.pravin.mvvmdiexample.di.module.fragment

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.viewmodel.fragment.PageFrgViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 12/19/2017.
 */
@Module
class PageFrgModule {
    @Provides
    fun providePageFrgViewModel(dataManager: DataManager)
            = PageFrgViewModel(dataManager)
}