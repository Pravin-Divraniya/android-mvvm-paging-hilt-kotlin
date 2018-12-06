package com.clarion.mvvmdiexample.di.module

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.activity.PagerActivity
import com.clarion.mvvmdiexample.view.adapter.BasePagerAdapter
import com.clarion.mvvmdiexample.viewmodel.activity.PagerViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 12/15/2017.
 */
@Module
class PagerActivityModule {
    @Provides
    fun providePagerViewModel(dataManager: DataManager)
            = PagerViewModel(dataManager)

    @Provides
    fun providePagerAdapter(activity:PagerActivity)
            = BasePagerAdapter(activity.supportFragmentManager)
}