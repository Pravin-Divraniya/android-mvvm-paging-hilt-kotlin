package com.clarion.mvvmdiexample.di.module

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.viewmodel.activity.MainViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 11/20/2017.
 */
@Module
class MainActivityModule {
    @Provides
    fun provideMainViewModel(dataManager: DataManager)
            = MainViewModel(dataManager)
}