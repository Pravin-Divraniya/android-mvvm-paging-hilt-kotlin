package com.clarion.mvvmdiexample.viewmodel.fragment

import android.arch.lifecycle.MutableLiveData
import android.content.res.Resources
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.api.GalleryImages
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.adapter.GalleryAdapter
import com.clarion.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

class GalleryViewModel(dataManager: DataManager):
    BaseViewModel<GalleryFragmentNavigator>(dataManager){

    val mAdapter = ObservableField<GalleryAdapter>()
    val dataList:MutableLiveData<MutableList<GalleryImages>> = MutableLiveData()
    val isAllCbChecked = ObservableBoolean()

    @Bindable
    fun getOnSelectAllClickListener() = View.OnClickListener{view ->
        val checkBox = view as CheckBox
        isAllCbChecked.set(checkBox.isChecked)
        Thread(Runnable {
            for((index,value) in dataList.value!!.withIndex()){
                value.isChecked = checkBox.isChecked
                dataList.value?.set(index,value)
            }
            dataList.postValue(dataList.value)
        }).start()
    }

    fun loadInitialData(resources:Resources):MutableList<GalleryImages>{
        val imageList:MutableList<GalleryImages> = ArrayList()
        Thread(Runnable {
            for ((index,value) in resources.getStringArray(R.array.gallery_image_urls).withIndex()){
                imageList.add(GalleryImages(index.toShort(),value))
            }
            dataList.postValue(imageList)
        }).start()
        return imageList
    }

    companion object {
        @JvmStatic
        @BindingAdapter("mAdapter")
        fun setAdapter(view: RecyclerView, adapter:GalleryAdapter?){
            if(null == adapter)
                return
            view.adapter = adapter
        }
    }
}