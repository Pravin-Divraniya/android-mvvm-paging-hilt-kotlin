package com.pravin.mvvmdiexample.viewmodel.fragment

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.navigator.PageFrgNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 12/19/2017.
 */
class PageFrgViewModel(dataManager: DataManager)
    : BaseViewModel<PageFrgNavigator>(dataManager) {

    private var mPageText = ""

    fun setPageText(text:String){
        mPageText = text
        notifyPropertyChanged(BR.pageText)
    }

    @Bindable
    fun getPageText() = mPageText
}