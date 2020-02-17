package com.pravin.mvvmdiexample.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.api.GalleryImages
import com.pravin.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.pravin.mvvmdiexample.viewmodel.list.GalleryItemViewModel

class GalleryAdapter(itemCallback: DiffUtil.ItemCallback<GalleryImages>, navigator: GalleryFragmentNavigator):
        BaseListAdapter<GalleryImages, GalleryItemViewModel>(itemCallback) {
    private val itemNavigator = navigator
    override fun getLayoutId() =
            R.layout.frg_gallery_list

    override fun getViewModel():GalleryItemViewModel{
        val galleryItemViewModel = GalleryItemViewModel()
        galleryItemViewModel.setNavigator(itemNavigator)
        return galleryItemViewModel
    }

    override fun getVariableId() =
            BR.galleryItemViewModel

    companion object {
        val DIFF_CALLBACK:DiffUtil.ItemCallback<GalleryImages> = object: DiffUtil.ItemCallback<GalleryImages>() {
            override fun areItemsTheSame(oldItem: GalleryImages, newItem: GalleryImages) =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: GalleryImages, newItem: GalleryImages) =
                    oldItem == newItem
        }
    }
}