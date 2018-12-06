package com.clarion.mvvmdiexample.viewmodel.fragment

import android.view.View
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.MyDialogFrgNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class MyDialogFrgViewModel(dataManager: DataManager) :
        BaseViewModel<MyDialogFrgNavigator>(dataManager) {

    fun onUpdateClick():View.OnClickListener{
        return View.OnClickListener { getNavigator()!!.onUpdateClick() }
    }

    fun onDeleteClick():View.OnClickListener{
        return View.OnClickListener { getNavigator()!!.onDeleteClick() }
    }


}