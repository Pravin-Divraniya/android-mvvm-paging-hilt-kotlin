package com.clarion.mvvmdiexample.viewmodel.fragment

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.support.v7.widget.RecyclerView
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.adapter.RemoteDataAdapter
import com.clarion.mvvmdiexample.view.navigator.RemoteDataFragmentNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class RemoteDataViewModel(dataManager: DataManager) :
        BaseViewModel<RemoteDataFragmentNavigator>(dataManager) {

    val adapter = ObservableField<RemoteDataAdapter>()

    fun getNews(apiKey:String) = getDataManager().getNews(apiKey)
    fun getPhotos() = getDataManager().getPhotos()
    fun getAlbums() = getDataManager().getAlbums()
    fun getComments() = getDataManager().getComments()
    fun getPosts() = getDataManager().getPosts()

    companion object {
        @JvmStatic
        @BindingAdapter("app:mAdapter")
        fun setAdapter(view: RecyclerView,adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>?){
            if(null == adapter)
                return
            view.adapter = adapter
        }
    }
}