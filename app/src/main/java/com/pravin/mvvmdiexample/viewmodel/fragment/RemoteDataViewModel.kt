package com.pravin.mvvmdiexample.viewmodel.fragment

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.adapter.RemoteDataAdapter
import com.pravin.mvvmdiexample.view.navigator.RemoteDataFragmentNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

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