package com.pravin.mvvmdiexample.di.module

import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.activity.PersonListActivity
import com.pravin.mvvmdiexample.view.adapter.PersonListAdapter
import com.pravin.mvvmdiexample.viewmodel.activity.PersonListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
@Module
class PersonListActivityModule {
    
    @Provides
    fun providePersonListAdapter(activity: PersonListActivity) =
            PersonListAdapter(ArrayList(),activity)

}