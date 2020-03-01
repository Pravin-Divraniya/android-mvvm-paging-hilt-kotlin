package com.pravin.mvvmdiexample.viewmodel.list

import android.view.View
import android.widget.CheckBox
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.pravin.mvvmdiexample.data.model.api.GalleryImages
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

@ActivityContext
class GalleryItemViewModel: ListItemViewModel<GalleryImages>() {
    private lateinit var galleryImages: GalleryImages

    override fun setItem(item: GalleryImages) {
        this.galleryImages = item
        notifyChange()
    }

    override fun getItem() = galleryImages

    @Bindable
    fun getImageUrl():String = galleryImages.url

    private fun setChecked(isChecked:Boolean){
        galleryImages.isChecked = isChecked
        notifyPropertyChanged(BR.checked)
    }

    @Bindable
    fun isChecked() = galleryImages.isChecked

    @Bindable
    fun getOnCBClickListener() = View.OnClickListener{view ->
        val checkBox = view as CheckBox
        setChecked(checkBox.isChecked)
        (getNavigator() as GalleryFragmentNavigator).onItemCheck(isChecked(),getItem())
    }

    @Bindable
    fun getOnImageClickListener() = View.OnClickListener {
        setChecked(!isChecked())
        (getNavigator() as GalleryFragmentNavigator).onItemCheck(isChecked(),getItem())
    }
}