package com.pravin.mvvmdiexample.viewmodel.fragment

import android.content.res.Resources
import android.view.View
import android.widget.CheckBox
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.api.GalleryImages
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.adapter.GalleryAdapter
import com.pravin.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

class GalleryViewModel(dataManager: DataManager):
    BaseViewModel<GalleryFragmentNavigator>(dataManager){

    val mAdapter = ObservableField<GalleryAdapter>()
    val dataList: MutableLiveData<MutableList<GalleryImages>> = MutableLiveData()
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