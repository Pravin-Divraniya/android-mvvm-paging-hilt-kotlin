package com.clarion.mvvmdiexample.di.module

import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.activity.PersonListActivity
import com.clarion.mvvmdiexample.view.adapter.PersonListAdapter
import com.clarion.mvvmdiexample.viewmodel.activity.PersonListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
@Module
class PersonListActivityModule {

    @Provides
    fun providePersonListViewModel(dataManager: DataManager) =
            PersonListViewModel(dataManager)

    @Provides
    fun providePersonListAdapter(activity: PersonListActivity) =
            PersonListAdapter(ArrayList(),activity)

}