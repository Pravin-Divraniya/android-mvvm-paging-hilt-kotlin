package com.clarion.mvvmdiexample.viewmodel.fragment

import android.databinding.Bindable
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.PageFrgNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

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