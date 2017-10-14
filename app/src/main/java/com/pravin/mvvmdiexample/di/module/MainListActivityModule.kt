package com.pravin.mvvmdiexample.di.module

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.viewmodel.MainListViewModel
import com.pravin.mvvmdiexample.viewmodel.PersonItemViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
@Module
class MainListActivityModule {
    @Provides
    fun provideMainListViewModel(dataManager: DataManager) =
            MainListViewModel(dataManager)

    @Provides
    fun providePersonItemViewModel() = PersonItemViewModel()
}