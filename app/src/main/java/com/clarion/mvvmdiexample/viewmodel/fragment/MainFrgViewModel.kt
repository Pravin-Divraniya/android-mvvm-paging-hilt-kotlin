package com.clarion.mvvmdiexample.viewmodel.fragment

import android.view.View
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.MainFrgNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

class MainFrgViewModel(dataManager: DataManager):
        BaseViewModel<MainFrgNavigator>(dataManager){

    fun onLocalDBClick() =  View.OnClickListener { getNavigator()?.openDBActivity() }
    fun onRemoteDataClick() = View.OnClickListener { getNavigator()?.openRemoteDataFragment() }
    fun onViewPagerClick() =  View.OnClickListener { getNavigator()?.openViewPagerActivity() }
    fun onGalleryViewClick() =  View.OnClickListener { getNavigator()?.openGalleryViewFragment() }
}