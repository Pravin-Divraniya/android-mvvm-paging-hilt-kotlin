package com.pravin.mvvmdiexample.viewmodel.list

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.api.GalleryImages
import com.pravin.mvvmdiexample.utils.defaultRequest
import com.pravin.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

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

    companion object {
        @JvmStatic
        @BindingAdapter("url")
        fun loadImage(view:ImageView,url:String){
            Glide.with(view)
                    .setDefaultRequestOptions(defaultRequest(R.drawable.placeholder,R.drawable.noimageplaceholder))
                    .load(url)
                    .thumbnail(0.2F)
                    .into(view)
        }
    }
}