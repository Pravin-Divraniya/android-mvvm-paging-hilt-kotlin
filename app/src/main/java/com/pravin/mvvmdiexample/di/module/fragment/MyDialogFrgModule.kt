package com.pravin.mvvmdiexample.di.module.fragment

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.viewmodel.fragment.MyDialogFrgViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 11/29/2017.
 */
@Module
class MyDialogFrgModule {
    @Provides
    fun provideMyDialogViewModel(dataManager: DataManager) =
            MyDialogFrgViewModel(dataManager)
}