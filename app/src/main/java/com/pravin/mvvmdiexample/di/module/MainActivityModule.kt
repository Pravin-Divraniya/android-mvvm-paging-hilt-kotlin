package com.pravin.mvvmdiexample.di.module

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.viewmodel.activity.MainViewModel
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