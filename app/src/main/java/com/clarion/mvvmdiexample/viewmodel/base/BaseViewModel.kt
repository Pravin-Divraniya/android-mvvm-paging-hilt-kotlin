package com.clarion.mvvmdiexample.viewmodel.base

import com.clarion.mvvmdiexample.data.model.manager.DataManager

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
open class BaseViewModel<T>(dataManager: DataManager): ViewModel() {
    private val mDataManager: DataManager = dataManager
    private var mNavigator:T? = null
    protected fun getDataManager() = mDataManager

    fun setNavigator(navigator:T){
        mNavigator = navigator
    }

    fun getNavigator() = mNavigator
}