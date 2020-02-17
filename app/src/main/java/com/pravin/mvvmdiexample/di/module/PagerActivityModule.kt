package com.pravin.mvvmdiexample.di.module

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.activity.PagerActivity
import com.pravin.mvvmdiexample.view.adapter.BasePagerAdapter
import com.pravin.mvvmdiexample.viewmodel.activity.PagerViewModel
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