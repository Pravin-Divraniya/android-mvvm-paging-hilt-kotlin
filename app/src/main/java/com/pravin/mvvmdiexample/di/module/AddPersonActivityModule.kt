package com.pravin.mvvmdiexample.di.module

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.viewmodel.activity.AddPersonViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Module
class AddPersonActivityModule {
    @Provides
    fun provideAddPersonViewModel(dataManager: DataManager)
            = AddPersonViewModel(dataManager)
}