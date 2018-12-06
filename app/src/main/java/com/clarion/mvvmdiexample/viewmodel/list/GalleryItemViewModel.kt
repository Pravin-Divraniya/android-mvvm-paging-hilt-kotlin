package com.clarion.mvvmdiexample.viewmodel.list

import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.api.GalleryImages
import com.clarion.mvvmdiexample.utils.defaultRequest
import com.clarion.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.clarion.mvvmdiexample.viewmodel.base.ListItemViewModel

class GalleryItemViewModel: ListItemViewModel<GalleryImages>() {
    private lateinit var galleryImages: GalleryImages

    override fun setItem(item: GalleryImages) {
        this.galleryImages = item
        notifyChange()
    }

    override fun getItem() = galleryImages

    @Bindable
    fun getImageUrl():String? = galleryImages.url

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

    companion object {
        @JvmStatic
        @BindingAdapter("bind:url")
        fun loadImage(view:ImageView,url:String){
            Glide.with(view)
                    .setDefaultRequestOptions(defaultRequest(R.drawable.placeholder,R.drawable.noimageplaceholder))
                    .load(url)
                    .thumbnail(0.2F)
                    .into(view)
        }
    }
}