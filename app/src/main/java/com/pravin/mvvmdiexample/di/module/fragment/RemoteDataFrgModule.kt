package com.pravin.mvvmdiexample.di.module.fragment

import com.pravin.mvvmdiexample.data.model.BaseModel
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.adapter.RemoteDataAdapter
import com.pravin.mvvmdiexample.view.fragment.RemoteDataFragment
import com.pravin.mvvmdiexample.viewmodel.fragment.RemoteDataViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Pravin Divraniya on 11/21/2017.
 */
@Module
class RemoteDataFrgModule {
    @Provides
    fun provideRemoteDataViewModel(dataManager: DataManager)
            = RemoteDataViewModel(dataManager)

    @Provides
    fun provideRemoteDataAdapter(fragment: RemoteDataFragment) =
            RemoteDataAdapter(ArrayList<BaseModel>(),fragment)

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}