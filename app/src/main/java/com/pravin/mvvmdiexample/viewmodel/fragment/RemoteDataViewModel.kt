package com.pravin.mvvmdiexample.viewmodel.fragment

import androidx.databinding.ObservableField
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.adapter.RemoteDataAdapter
import com.pravin.mvvmdiexample.view.navigator.RemoteDataFragmentNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
@ActivityContext
class RemoteDataViewModel(dataManager: DataManager) :
        BaseViewModel<RemoteDataFragmentNavigator>(dataManager) {

    val adapter = ObservableField<RemoteDataAdapter>()

    fun getNews(apiKey:String) = getDataManager().getNews(apiKey)
    fun getPhotos() = getDataManager().getPhotos()
    fun getAlbums() = getDataManager().getAlbums()
    fun getComments() = getDataManager().getComments()
    fun getPosts() = getDataManager().getPosts()
}