package com.pravin.mvvmdiexample.viewmodel.fragment

import android.view.View
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.navigator.MainFrgNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

@ActivityContext
class MainFrgViewModel(dataManager: DataManager) :
		BaseViewModel<MainFrgNavigator>(dataManager) {
	
	fun onLocalDBClick() = View.OnClickListener { getNavigator()?.openDBActivity() }
	fun onRemoteDataClick() = View.OnClickListener { getNavigator()?.openRemoteDataFragment() }
	fun onViewPagerClick() = View.OnClickListener { getNavigator()?.openViewPagerActivity() }
	fun onGalleryViewClick() = View.OnClickListener { getNavigator()?.openGalleryViewFragment() }
}