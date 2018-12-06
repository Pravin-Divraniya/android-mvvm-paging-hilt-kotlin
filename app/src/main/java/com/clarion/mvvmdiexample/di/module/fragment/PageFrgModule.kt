package com.clarion.mvvmdiexample.di.module.fragment

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.viewmodel.fragment.PageFrgViewModel
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