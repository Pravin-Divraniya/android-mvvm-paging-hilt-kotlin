package com.clarion.mvvmdiexample.di.module

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.viewmodel.activity.AddPersonViewModel
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