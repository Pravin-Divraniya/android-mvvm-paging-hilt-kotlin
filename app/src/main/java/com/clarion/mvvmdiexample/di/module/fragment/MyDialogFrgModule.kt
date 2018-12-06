package com.clarion.mvvmdiexample.di.module.fragment

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.viewmodel.fragment.MyDialogFrgViewModel
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