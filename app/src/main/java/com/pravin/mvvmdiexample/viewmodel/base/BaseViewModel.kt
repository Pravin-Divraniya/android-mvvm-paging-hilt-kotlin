package com.pravin.mvvmdiexample.viewmodel.base

import com.pravin.mvvmdiexample.data.model.manager.DataManager

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
open class BaseViewModel<T>(dataManager: DataManager): ViewModel() {
    private val mDataManager: DataManager
    private var mNavigator:T? = null
    init {
        this.mDataManager = dataManager
    }
    protected fun getDataManager() = mDataManager

    fun setNavigator(navigator:T){
        mNavigator = navigator
    }

    fun getNavigator() = mNavigator
}