package com.clarion.mvvmdiexample.view.adapter

import android.support.v7.util.DiffUtil
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.api.GalleryImages
import com.clarion.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.clarion.mvvmdiexample.viewmodel.list.GalleryItemViewModel

class GalleryAdapter(itemCallback: DiffUtil.ItemCallback<GalleryImages>,navigator: GalleryFragmentNavigator):
        BaseListAdapter<GalleryImages, GalleryItemViewModel>(itemCallback) {
    val ItemNavigator = navigator
    override fun getLayoutId() =
            R.layout.frg_gallery_list

    override fun getViewModel():GalleryItemViewModel{
        val galleryItemViewModel = GalleryItemViewModel()
        galleryItemViewModel.setNavigator(ItemNavigator)
        return galleryItemViewModel
    }

    override fun getVariableId() =
            BR.galleryItemViewModel

    companion object {
        val DIFF_CALLBACK:DiffUtil.ItemCallback<GalleryImages> = object: DiffUtil.ItemCallback<GalleryImages>() {
            override fun areItemsTheSame(oldItem: GalleryImages?, newItem: GalleryImages?) =
                    oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: GalleryImages?, newItem: GalleryImages?) =
                    oldItem == newItem
        }
    }
}