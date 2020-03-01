package com.pravin.mvvmdiexample.viewmodel.fragment

import android.view.View
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.navigator.MyDialogFrgNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
@ActivityContext
class MyDialogFrgViewModel(dataManager: DataManager) :
        BaseViewModel<MyDialogFrgNavigator>(dataManager) {

    fun onUpdateClick():View.OnClickListener{
        return View.OnClickListener { getNavigator()!!.onUpdateClick() }
    }

    fun onDeleteClick():View.OnClickListener{
        return View.OnClickListener { getNavigator()!!.onDeleteClick() }
    }


}